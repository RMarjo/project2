package com.example.mrenaud.mesrecettesdecrepes.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mrenaud.mesrecettesdecrepes.interfaces.GetRecipeListener;
import com.example.mrenaud.mesrecettesdecrepes.GetRecipeTask;
import com.example.mrenaud.mesrecettesdecrepes.interfaces.ItemClickListener;
import com.example.mrenaud.mesrecettesdecrepes.R;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;
import com.example.mrenaud.mesrecettesdecrepes.RecipesAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private String ws = "https://raw.githubusercontent.com/raywenderlich/recipes/master/Recipes.json";  // adresse url
    private RecipesAdapter adapter;
    //final String ONE_RECIPE_KEY="oneRecipeKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new RecipesAdapter(this, this);

        RecyclerView recyclerView = findViewById(R.id.main_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new GetRecipeTask(new GetRecipeListener() {
            @Override
            public void onRecipeLoaded(List <Recipes> recipesList) {

                //TODO update adapter data
                adapter.setItemList(recipesList);
            }
        }).execute(ws);
    }

    @Override
    public void onTextClick(int position) {
        //TODO handle this
        adapter.getItemIdAtPosition(position);
        //TODO start new activity

        startActivity(OneRecipeActivity.newInstance(this, position));
    }

    @Override
    public void onIconClick(int position) {
        //displaytoast
    }
}
