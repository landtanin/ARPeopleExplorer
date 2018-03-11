package com.landtanin.arpersonexplorer.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 6/5/2560.
 */

/**
 * init instance of this class to for object initialisation
 */
public class HttpManager {
    private static HttpManager instance;

    // init instance of this class to for object initialisation
    public static HttpManager getInstance() {

        if (instance == null) {
            instance = new HttpManager();
        }
        return instance;

    }


    private Context mContent;
    private ApiService service;

    /**
     * use application context
     * Create instance of Retrofit with base URL
     * form the connection (full URL) with the ApiService
     */
    private HttpManager() {

        // use application context
        mContent = Contextor.getInstance().getContext();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        // Create instance of Retrofit with base URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://adamfield.net/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //http://api.fixer.io/latest?base=GBP

        // form the connection (full URL) with the ApiService
        service = retrofit.create(ApiService.class);

    }

    /**
     * get method to get the connection service
     * @return
     */
    public ApiService getService() {

        // get method to get the connection service
        return service;
    }

}
