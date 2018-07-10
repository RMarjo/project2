package com.example.mrenaud.mesrecettesdecrepes;

import android.os.AsyncTask;

import com.example.mrenaud.mesrecettesdecrepes.interfaces.GetRecipeListener;
import com.example.mrenaud.mesrecettesdecrepes.model.Ingredient;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;
import com.example.mrenaud.mesrecettesdecrepes.model.Steps;
import com.example.mrenaud.mesrecettesdecrepes.model.Timers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetRecipeTask extends AsyncTask <String, Void, List <Recipes>> {  // <= pb de parameter
    private HttpURLConnection urlConnection;
    private URL url = null;
    private GetRecipeListener getRecipeListener;

    public GetRecipeTask(GetRecipeListener getRecipeListener) {
        this.getRecipeListener = getRecipeListener;
    }


    protected void onPreExecute() {
        super.onPreExecute();
    }


    protected List <Recipes> doInBackground(String... strings) { //<= ??????
        JSONArray response;
        String stringURL = strings[0];
        InputStream inputStream = null;
        List <Recipes> recipesList = new ArrayList <>();


        try {
            url = new URL(stringURL);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            int responseInt = urlConnection.getResponseCode();
            if (responseInt != 200) {
                return null;
            }
            inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return null;
            }
            ;

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }

            response = new JSONArray(buffer.toString());
            try {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject recipeJsonObj = response.getJSONObject(i);

                    Recipes recipes = new Recipes();
// tableau des ingredients
                    JSONArray ingredientsJSONArray = recipeJsonObj.getJSONArray("ingredients");
                    List <Ingredient> ingredientList = new ArrayList <>();
                    for (int j = 0; j < ingredientsJSONArray.length(); j++) {
                        JSONObject ingredientJSONObject = ingredientsJSONArray.optJSONObject(j);

                        Ingredient ingredient = new Ingredient();
                        ingredient.setName(ingredientJSONObject.optString("name"));
                        ingredient.setQuantity(ingredientJSONObject.optString("quantity"));
                        ingredient.setType(ingredientJSONObject.optString("type"));
                        ingredientList.add(ingredient);
                    }
// list des etapes/steps
                    JSONArray stepsJSONArray = recipeJsonObj.getJSONArray("steps");
                    List <Steps> stepsList = new ArrayList <>();
                    for (int j = 0; j <stepsJSONArray.length() ; j++) {
                        Steps steps = new Steps();
                        stepsList.add(steps);

                    }

                    JSONArray timersJSONArray = recipeJsonObj.getJSONArray("timers");
                    List<Timers> timersList = new ArrayList <>();
                    for (int j = 0; j <timersJSONArray.length() ; j++) {
                        Timers timers = new Timers();
                        timersList.add(timers);

                    }


// list des timers
                    recipes.setTimers(timersList);
                    recipes.setSteps(stepsList);
                    recipes.setIngredients(ingredientList);
                    recipes.setName(recipeJsonObj.optString("name"));
                    recipes.setImageURL(recipeJsonObj.optString("imageURL"));


                    recipesList.add(recipes);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            //urlConnection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignored) {

                }

            }
        }


        return recipesList;


        // ;
    }


    protected void onPostExecute(List <Recipes> recipesList) {
        //List<Recipes> recipesList = new ArrayList<>();
        getRecipeListener.onRecipeLoaded(recipesList);

    }
}

