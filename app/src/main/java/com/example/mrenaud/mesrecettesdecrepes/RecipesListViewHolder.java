package com.example.mrenaud.mesrecettesdecrepes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class RecipesListViewHolder extends RecyclerView.ViewHolder {


    private TextView textNameView;
    private ImageView imageView;
    // List => ingredient/step/timer ?????


    private TextView textIngredientView;
    private TextView textStepView;
    private TextView texTimerView;


    public RecipesListViewHolder(View itemView){
        super(itemView);

        textNameView= (TextView)itemView.findViewById(R.id.one_recipe_textNameView);
        imageView=(ImageView)itemView.findViewById(R.id.one_recipe_imageView);
        textIngredientView =( TextView) itemView.findViewById(R.id.one_recipe_textIngredient);

    }

    public void bind(Recipes recipes){

        textNameView.setText(recipes.getName());
       // textIngredientView.setText((CharSequence) recipes.getIngredient());
        //Picasso.with(imageView.getContext()).load(recipes.getImageUrl()).centerCrop().fit().into(imageView);
    }
}
