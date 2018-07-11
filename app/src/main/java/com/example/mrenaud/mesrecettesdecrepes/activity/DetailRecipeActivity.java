package com.example.mrenaud.mesrecettesdecrepes.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.mrenaud.mesrecettesdecrepes.Cache;
import com.example.mrenaud.mesrecettesdecrepes.R;
import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;

public class DetailRecipeActivity extends Activity {


    // constante de la clef de l'intent
    public static final String ONE_RECIPE_KEY = "onRecipeKey";
    /***************************/
    public static Intent newInstance(Context context, int position) {
        Intent intent = new Intent(context, DetailRecipeActivity.class);
        intent.putExtra(DetailRecipeActivity.ONE_RECIPE_KEY, position);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_detail_activity);

        Intent intent = getIntent();
        if (intent != null) {
            int position = 0;
            if (intent.hasExtra(ONE_RECIPE_KEY)) {
                position = intent.getIntExtra(ONE_RECIPE_KEY, 0);
            }
            TextView textNameView = (TextView) findViewById(R.id.recipes_details_name);
            textNameView.setText(Cache.getInstance().getItemNameAtPosition(position));

        }

    }

}
