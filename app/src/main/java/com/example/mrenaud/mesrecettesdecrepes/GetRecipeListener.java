package com.example.mrenaud.mesrecettesdecrepes;

import java.util.List;

public interface GetRecipeListener {
    void onRecipeLoaded(List<Recipes> recipesList);
}
