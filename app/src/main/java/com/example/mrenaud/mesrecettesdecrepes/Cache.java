package com.example.mrenaud.mesrecettesdecrepes;

import com.example.mrenaud.mesrecettesdecrepes.model.Recipes;

import java.util.List;

public class Cache {

    private static Cache instance;

    private List<Recipes> recipesList;

    public static Cache getInstance(){
        if(instance == null){
            instance = new Cache();
        }
        return instance;
    }

    // faire getter / setter y compris avec la position
    public void setRecipesList(List <Recipes> recipesList) {
        this.recipesList = recipesList;
    }

    public List <Recipes> getRecipesList() {
        return recipesList;
    }

    // + method pour récuperer l'item via la position (id) 
    public String getItemNameAtPosition(int position){
        if(recipesList == null ||  position < 0){
            return "Houston nous avons un souci ";
        }
        return recipesList.get(position).getName();
        // renvoyer directement l'objet recipe.
    }



}
