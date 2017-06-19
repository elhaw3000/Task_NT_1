package com.mostafaelhaw.task_1.activity;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.design.widget.Snackbar;
import android.widget.Toast;


import com.mostafaelhaw.task_1.R;
import com.mostafaelhaw.task_1.adapter.MyRecipeAdapter;
import com.mostafaelhaw.task_1.model.recipe;
import com.mostafaelhaw.task_1.model.recipeResponse;
import com.mostafaelhaw.task_1.rest.ApiClient;
import com.mostafaelhaw.task_1.rest.ApiService;
import com.mostafaelhaw.task_1.utils.InternetConnection;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String API_KEY = "axV15293h59oU9Z853fw48CmI1H1Js";

    //* Views
    private ListView listView;
    private View parentView;

    private ArrayList<recipe> recipeList;
    private MyRecipeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * Array List for Binding Data from JSON to this List
         */
        recipeList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parentView, recipeList.get(position).getTitle() , Snackbar.LENGTH_LONG).show();
            }
        });

        /* *
         *
         */
       //  Just to know onClick and Printing Hello Toast in Center.


        Toast toast = Toast.makeText(getApplicationContext(), R.string.string_click_to_load, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull final View view) {

                /**
                 * Checking Internet Connection
                 */
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    /**
                     * Progress Dialog for User Interaction
                     */
                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setTitle(getString(R.string.string_getting_json_title));
                    dialog.setMessage(getString(R.string.string_getting_json_message));
                    dialog.show();



                    //Creating an object of our api interface
                    ApiService api = ApiClient.getApiService();

                    /**
                     * Calling JSON
                     */
                    Call<recipeResponse> call = api.getMyJson();

                    /**
                     * Enqueue Callback will be call when get response...
                     */
                    call.enqueue(new Callback<recipeResponse>() {
                        @Override
                        public void onResponse(Call<recipeResponse> call, Response<recipeResponse> response) {
                          //  Dismiss Dialog
                            dialog.dismiss();

                            if(response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                recipeList = (ArrayList<recipe>) response.body().getResults();

                                /**
                                 * Binding that List to Adapter
                                 */
                                adapter = new MyRecipeAdapter(MainActivity.this, recipeList);
                                listView.setAdapter(adapter);

                            }
                            else {
                                Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();  }

                        }



                        @Override
                        public void onFailure(Call<recipeResponse> call, Throwable t) {

                        }
                    });

                }
                else {
                    Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show(); }
            }
        });
    }
}