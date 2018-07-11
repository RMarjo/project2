package com.example.mrenaud.mesrecettesdecrepes;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrenaud.mesrecettesdecrepes.interfaces.ItemClickListener;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;
import com.squareup.picasso.Picasso;


public class RecipesListViewHolder extends RecyclerView.ViewHolder {

    private TextView textNameView;
    private ImageView imageView;
    // List => ingredient/step/timer ?????


    private TextView textIngredientView;
    private TextView textStepView;
    private TextView texTimerView;

    private View currentView;


    public RecipesListViewHolder(View itemView) {
        super(itemView);

        textNameView = (TextView) itemView.findViewById(R.id.one_recipe_textNameView);
        imageView = (ImageView) itemView.findViewById(R.id.one_recipe_imageView);
        //textIngredientView = (TextView) itemView.findViewById(R.id.one_recipe_textIngredient);

        currentView = itemView;

    }

    public void bind(Recipes recipes) {

        textNameView.setText(recipes.getName());
        // textIngredientView.setText(TextUtils.join(", ", recipes.getIngredient()));
        // textStepView.setText(TextUtils.join(", ", recipes.getSteps()));
        Picasso.with(imageView.getContext()).load(recipes.getImageUrl()).centerCrop().fit().into(imageView);
    }

    public void setClickListener(final ItemClickListener itemClickListener) {
        //TODO set listener to view
        textNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onRecipeTextClick(getAdapterPosition());
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onIconClick(getAdapterPosition());
            }
        });
    }

}
