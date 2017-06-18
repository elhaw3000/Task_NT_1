package com.mostafaelhaw.task_1.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mostafa_elhaw on 6/18/2017.
 */
public class ApiClient {
    public static final String BASE_URL="https://api2.bigoven.com/Recipes?Title_kw=oysters&pg=1&rpp=20&api_key=axV15293h59oU9Z853fw48CmI1H1Js";
  //  private static Retrofit retrofit=null;

    public static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
        //return retrofit;
    }
}
