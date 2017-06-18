package com.mostafaelhaw.task_1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by mostafa_elhaw on 6/18/2017.
 */

public class recipe {

    @SerializedName("PhotoUrl")
    private String PhotoUrl;

    @SerializedName("Category")
    private String Category;

    @SerializedName("RecipeID")
    private Integer RecipeID;

    @SerializedName("Title")
    private String Title;
    @SerializedName("StarRating")
    private Double StarRating;

    public recipe(String PhotoUrl, Integer RecipeID, String Title, Double StarRating,String Category){
        this.PhotoUrl = PhotoUrl;
        this.RecipeID = RecipeID;
        this.Category=Category;
        this.Title=Title;
        this.StarRating=StarRating;
    }
    public String getPhotoUrl() {
        return PhotoUrl;
    }
    public void setPhotoURL(String PhotoUrl) {
        this.PhotoUrl = PhotoUrl;
    }

    public Integer getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.RecipeID = recipeID;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getCategory(){
        return Category;
    }
    public void setCategory(String Category){
        this.Category=Category;
    }


    public Double getStarRating() {
        return StarRating;
    }

    public void setStarRating(Double StarRating) {
        this.StarRating = StarRating;
    }

}
