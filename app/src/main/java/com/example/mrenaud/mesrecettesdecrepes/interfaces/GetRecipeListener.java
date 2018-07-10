package com.example.mrenaud.mesrecettesdecrepes.interfaces;

import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;

import java.util.List;

public interface GetRecipeListener {
    void onRecipeLoaded(List<Recipes> recipesList);
}
