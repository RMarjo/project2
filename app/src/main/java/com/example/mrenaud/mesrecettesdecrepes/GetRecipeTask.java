package com.example.mrenaud.mesrecettesdecrepes;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetRecipeTask extends AsyncTask<String, Void, JSONObject> {
    private HttpURLConnection urlConnection;
    private URL url = null;
    private GetRecipeListener getRecipeListener;

    public GetRecipeTask(GetRecipeListener getRecipeListener) {
        this.getRecipeListener = getRecipeListener;
    }


    protected void onPreExecute() {
        super.onPreExecute();
    }


    protected JSONObject doInBackground(String... strings) {
        JSONObject response = null;
        String data = "";
        String stringURL=strings[0];

        try {
            url = new URL(stringURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                data += line;
            }

            response = new JSONObject(data);
            urlConnection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return response;
    }


    protected void onPostExecute(JSONObject result) {
        List<Recipes> recipesList = new ArrayList<>();
        try {
            JSONObject jsonObject = result.getJSONObject("response");
            JSONArray arr = jsonObject.getJSONArray("result");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject recipeJsonObj = arr.getJSONObject(i);

                Recipes recipes = new Recipes();
// tableau des ingredients
                JSONArray ingredientsJSONArray = recipeJsonObj.getJSONArray("ingredients");
                List<Ingredient> ingredientList = new ArrayList <>();
                for(int j = 0; j < ingredientsJSONArray.length(); j++){
                    JSONObject ingredientJSONObject = ingredientsJSONArray.optJSONObject(j);

                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(ingredientJSONObject.optString("name"));
                    ingredient.setQuantity(ingredientJSONObject.optString("quantity"));
                    ingredient.setType(ingredientJSONObject.optString("type"));
                    ingredientList.add(ingredient);
                }
// list des etapes/steps

                /*
// list des timers

                JSONArray timersJSONArray = recipeJsonObj.getJSONArray("timers");
                List<Timers> timersList= new ArrayList();
                for (int j = 0; j < timersJSONArray.length() ; j++) {
                    Timers timers = new Timers();
                    timersList.add(timers);

                }

// affiliation au tableau de recette/recipes

                recipes.setTimers(timersList);*/

                recipes.setIngredients(ingredientList);
                recipes.setName(recipeJsonObj.optString("name"));
                recipes.setImageURL(recipeJsonObj.optString("imageURL"));


                recipesList.add(recipes);

                getRecipeListener.onRecipeLoaded(recipesList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

