package com.hackathon.johndeere.Activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.johndeere.Model.Consume;
import com.hackathon.johndeere.Model.Info;
import com.hackathon.johndeere.R;
import com.hackathon.johndeere.Webservice.APIClient;
import com.hackathon.johndeere.Webservice.APIInterface;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Integer.parseInt;

/**
 * Created by Matheus on 02/02/2017.
 */

public class ConsumoFragment extends Fragment {

    TextView tvConsumoMedio;
    ImageView ivConsumo;

    public ConsumoFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    Call<String> call;
    APIInterface apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_consumo, container, false);

        tvConsumoMedio = (TextView) v.findViewById(R.id.tv_consumo_medio);

        ivConsumo = (ImageView) v.findViewById(R.id.iv_consumo);

        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                apiService = APIClient.getService().create(APIInterface.class);
                call = apiService.getInfoConsume();
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.raw().code() == 200) {
                            String resp = response.body().toString();

                            tvConsumoMedio.setText("" + resp + " L/h");

                            if(Double.parseDouble(resp) < 40) {
                                ivConsumo.setImageResource(R.drawable.d2);
                            } else if(Double.parseDouble(resp) > 40 && Double.parseDouble(resp) < 45) {
                                ivConsumo.setImageResource(R.drawable.d3);
                            } else if(Double.parseDouble(resp) > 45 && Double.parseDouble(resp) < 50) {
                                ivConsumo.setImageResource(R.drawable.d4);
                            } else if(Double.parseDouble(resp) > 55) {
                                ivConsumo.setImageResource(R.drawable.d5);
                            }

                            Log.d("LOGGED: ", response.body().toString());
                        }
                        Log.d("LOGGED: ", "Error");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                    }
                });
            }
        },0,2000);



        return v;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}