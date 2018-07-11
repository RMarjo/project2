package com.example.mrenaud.mesrecettesdecrepes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrenaud.mesrecettesdecrepes.interfaces.ItemClickListener;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;

import java.util.ArrayList;
import java.util.List;

// L'Adapter, c'est lui qui passe le sel entre les Recipes & le viewholder( qui savent ce qu'elles contiennent mais vide et qui savent quand les actions sont sencés se produire) et l'Activity qui sait ce qui se passent quand des actions sont faites.

public class RecipesAdapter extends RecyclerView.Adapter<RecipesListViewHolder>{

    private Context context;
    private List<Recipes> recipes;
    ItemClickListener itemClickListener;

    public RecipesAdapter(Context context, ItemClickListener itemClickListener){
        this.context = context;
        this.recipes=new ArrayList <>();
        //TODO keep ref to listener
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public RecipesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int itemType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_recipe_list, parent, false);
        return new RecipesListViewHolder(view);
    }



    public void onBindViewHolder(@NonNull RecipesListViewHolder holder, int position){

        final Recipes current=recipes.get(position);
        holder.bind(current);



        ///////*******************//////
        //TODO set kept listener
        holder.setClickListener(itemClickListener);
    }

    public String getItemIdAtPosition(int position){
        //TODO check if position is OK
        return recipes.get(position).getId();
    }

    public void setItemList(List<Recipes> recipesList){
        recipes.clear();
        recipes.addAll(recipesList);
        notifyDataSetChanged();
    }

    public int getItemCount(){
        return recipes.size();
    }
}
