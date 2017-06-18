package com.mostafaelhaw.task_1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mostafa_elhaw on 6/18/2017.
 */
public class recipeResponse {

    @SerializedName("ResultCount")
    private int ResultCount;
    @SerializedName("Results")
    @Expose
    private List<recipe> Results= new ArrayList<>();
/*
    public int getResultCount(int ResultCount){
        return ResultCount;
    }
    public void setResultCount(){
        this.ResultCount=ResultCount;
    }
    */
    public List<recipe> getResults(){
        return Results;
    }
    public void setResults(List<recipe> Results){
        this.Results=Results;
    }
}
