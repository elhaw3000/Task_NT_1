package com.mostafaelhaw.task_1.rest;

import com.mostafaelhaw.task_1.model.recipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mostafa_elhaw on 6/18/2017.
 */
public interface ApiService {
    @GET("/json_data.json")
    Call<recipeResponse> getMyJson();
            //(@Path("RecipeID") int RecipeID, @Query("api_key") String apiKey);

    // the api key axV15293h59oU9Z853fw48CmI1H1Js
}
