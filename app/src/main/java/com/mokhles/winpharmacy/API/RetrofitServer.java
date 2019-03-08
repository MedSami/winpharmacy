package com.mokhles.winpharmacy.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {
    //private static final String Base_Url="http://10.0.3.2/Pharmacy/";
    private static final String Base_Url="https://winpharmacy.000webhostapp.com/Pharmacy/";
    private static Retrofit retrofit;



    public static Retrofit getClient(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(360, TimeUnit.SECONDS)
                .connectTimeout(360, TimeUnit.SECONDS)
                .build();

       Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(Base_Url).
                            addConverterFactory(GsonConverterFactory.create(gson)).
                            client(okHttpClient).build();
        }
        return retrofit;
    }
}
