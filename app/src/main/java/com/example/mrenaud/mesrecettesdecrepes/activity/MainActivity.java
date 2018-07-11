package com.example.mrenaud.mesrecettesdecrepes.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mrenaud.mesrecettesdecrepes.Cache;
import com.example.mrenaud.mesrecettesdecrepes.interfaces.GetRecipeListener;
import com.example.mrenaud.mesrecettesdecrepes.GetRecipeTask;
import com.example.mrenaud.mesrecettesdecrepes.interfaces.ItemClickListener;
import com.example.mrenaud.mesrecettesdecrepes.R;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;
import com.example.mrenaud.mesrecettesdecrepes.RecipesAdapter;

import java.util.List;



// C'est a premiere activité, celle du démarrage.
public class MainActivity extends AppCompatActivity implements ItemClickListener {
    // on donne l'URL a aller chercher ( que l'on a passé en parametre de la fonction getRecipeTask
    private String ws = "https://raw.githubusercontent.com/raywenderlich/recipes/master/Recipes.json";  // adresse url
   // nom générique de l' adapter déclaré dans le RecipesAdapter
    private RecipesAdapter adapter;


// onCreate, fonction qui crée notre activité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // instance de la vue a remplir
        setContentView(R.layout.activity_main);
        //mise en context de l'adapter
        adapter = new RecipesAdapter(this, this);

        // indexation de la vue associé au RecyclerView
        RecyclerView recyclerView = findViewById(R.id.main_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // mise en place de l'adapter associé a la RecyclerView
        recyclerView.setAdapter(adapter);
// fonction de remplissage de notre recyclerView par l'objet que nous avons récupéré via l'url
        new GetRecipeTask(new GetRecipeListener() {
            @Override
            public void onRecipeLoaded(List <Recipes> recipesList) {
// recuperation de la list qu'on envoi au cache
                Cache.getInstance().setRecipesList(recipesList);

                //TODO update adapter data
                adapter.setItemList(recipesList);
            }
        }).execute(ws);
    }

// Ce qui se passe quand on click sur une recette
    @Override
    public void onRecipeTextClick(int position) {
        // on récupere la position de l'item
        //TODO handle this
        adapter.getItemIdAtPosition(position);
        // on démarre la nouvelle activity en passant l'index ( sous le terme position )
        //TODO start new activity
        startActivity(DetailRecipeActivity.newInstance(this, position));
    }

    @Override
    public void onIconClick(int position) {
        //displaytoast
    }
}
