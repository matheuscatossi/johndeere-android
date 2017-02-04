package com.hackathon.johndeere.Activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.johndeere.Model.Consume;
import com.hackathon.johndeere.Model.Info;
import com.hackathon.johndeere.R;
import com.hackathon.johndeere.Webservice.APIClient;
import com.hackathon.johndeere.Webservice.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Matheus on 02/02/2017.
 */

public class ConsumoFragment extends Fragment {

    public ConsumoFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_consumo, container, false);

        APIInterface apiService = APIClient.getService().create(APIInterface.class);
        Call<Consume> call = apiService.getInfoConsume();
        call.enqueue(new Callback<Consume>() {
            @Override
            public void onResponse(Call<Consume> call, Response<Consume> response) {
                Log.d("LOGGED: ", response.body().toString());
            }

            @Override
            public void onFailure(Call<Consume> call, Throwable t) {
                Log.e("ERROR", t.toString());
            }
        });

        return v;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}