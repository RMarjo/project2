package com.example.mrenaud.mesrecettesdecrepes.model;

import java.util.List;

public class Recipes {

    private String id;
    private String name;
    private List<Ingredient> ingredient;
    private List <Steps> steps;
    private List <Timers> timers;
    private String imageURL;

    public Recipes() {
    }

    public Recipes( String id, String name, List<Ingredient> ingredient, List<Steps> steps, List <Timers> timers, String imageURL ){
            this.id =id;
            this.name = name;
            this.ingredient=ingredient;
            this.steps=steps;
            this.timers=timers;
            this.imageURL=imageURL;
    }

    // SET
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(List <Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public void setSteps(List <Steps> steps) {
        this.steps = steps;
    }

    public void setTimers(List <Timers> timers) {
        this.timers = timers;
    }

    public void setImageURL(String imageURL) {
        this.imageURL=imageURL;
    }
    // GET
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public List <Ingredient> getIngredient() {
        return ingredient;
    }

    public List<Steps> getSteps() {
        return steps;
    }

    public List getTimers() {
        return timers;
    }

    public String getImageUrl() {
        return imageURL;
    }
}

