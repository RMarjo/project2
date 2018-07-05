package com.example.mrenaud.mesrecettesdecrepes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    List<Recipes> recipes = Collections.emptyList();

    public RecipesAdapter(Context context, List<Recipes> recipes){
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.recipes=recipes;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int itemType) {
        View view = inflater.inflate(R.layout.one_recipe_list, parent, false);
        RecipesListViewHolder holder= new RecipesListViewHolder(view);
        return holder;
    }



    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){

        RecipesListViewHolder recipesListViewHolder=(RecipesListViewHolder) holder;
        Recipes current=recipes.get(position);
        recipesListViewHolder.bind(current);


        ///////*******************//////
    }

    public int getItemCount(){
        return recipes.size();
    }
}
