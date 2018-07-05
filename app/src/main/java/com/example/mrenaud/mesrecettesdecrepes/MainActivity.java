package com.example.mrenaud.mesrecettesdecrepes;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class MainActivity extends AppCompatActivity {


   String ws ="https://raw.githubusercontent.com/raywenderlich/recipes/master/Recipes.json";  // adresse url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//   évitement du crash pour le moment car main vide.

        new GetRecipeTask(new GetRecipeListener() {
            @Override
            public void onRecipeLoaded(List <Recipes> recipesList) {
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recycler_view);

                RecyclerView.Adapter adapter = new RecipesAdapter(MainActivity.this, recipesList);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }
        }).execute(ws);
        //new JSONParse().execute(ws); // <= appel de l'Asynctask

    }

    /*private class JSONParse extends AsyncTask <String, Void, JSONObject> {

        HttpURLConnection urlConnection;
        URL url = null;

        protected void onPreExecute() {
            super.onPreExecute();
        }


        protected JSONObject doInBackground(String... strings) {
            JSONObject response = null;
            String data = "";

            try {
                url = new URL(ws);
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
            List <Recipes> recipesList = new ArrayList <>();
            try {
                JSONObject jsonObject = result.getJSONObject("response");
                JSONArray arr = jsonObject.getJSONArray("result");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject recipeJsonObj = arr.getJSONObject(i);

                    Recipes recipes = new Recipes();

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
                    recipes.setIngredients(ingredientList);
                    recipes.setName(recipeJsonObj.optString("name"));

                    //recipeJsonObj.opA

                    recipesList.add(recipes);
                }

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recycler_view);

                RecyclerView.Adapter adapter = new RecipesAdapter(MainActivity.this, recipesList);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }*/


}
