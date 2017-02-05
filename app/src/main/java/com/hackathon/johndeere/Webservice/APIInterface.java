package com.hackathon.johndeere.Webservice;

import com.hackathon.johndeere.Model.Consume;
import com.hackathon.johndeere.Model.Info;
import com.hackathon.johndeere.Model.Message;
import com.hackathon.johndeere.Utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Victor Shinya on 03/02/2017.
 */

public interface APIInterface {

    @POST(Constants.SEND_MESSAGE)
    Call<Message> sendMessage(@Body String message);

    @GET(Constants.INFO)
    Call<Info> getInfo();

    @GET(Constants.INFO_CONSUME)
    Call<String> getInfoConsume();
}
