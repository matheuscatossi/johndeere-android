package com.hackathon.johndeere.Webservice;

import com.hackathon.johndeere.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor Shinya on 03/02/2017.
 */

public class APIClient {

    private static Retrofit retrofit = null;

    public Retrofit sendChat() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
