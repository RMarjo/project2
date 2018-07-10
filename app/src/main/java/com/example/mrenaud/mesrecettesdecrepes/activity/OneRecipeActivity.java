package com.example.mrenaud.mesrecettesdecrepes.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrenaud.mesrecettesdecrepes.R;

public class OneRecipeActivity extends Activity {
    // constante de la clef
    public static final String ONE_RECIPE_KEY = "onRecipeKey";

    public static Intent newInstance(Context context, int position){
        Intent intent = new Intent( context, OneRecipeActivity.class);
        intent.putExtra(OneRecipeActivity.ONE_RECIPE_KEY, position);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        if (intent != null) {
            int position=0;
            if (intent.hasExtra(ONE_RECIPE_KEY)) {
                position = intent.getIntExtra(ONE_RECIPE_KEY,0);
            }
            TextView textView = (TextView) findViewById(R.id.second_activity_name);
            textView.setText(String.valueOf(position));

        }
    }

}
