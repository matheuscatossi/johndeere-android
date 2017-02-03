package com.hackathon.johndeere.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Victor Shinya on 02/02/2017.
 */

public class Connection extends BroadcastReceiver {

    public String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                message = "Network " + networkInfo.getTypeName() + " connected";
                Log.i(Constants.TAG, message);
            } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {
                message = "There's no network connectivity";
                Log.d(Constants.TAG, message);
            } else {
                message = "Unregistered any connection";
                Log.d(Constants.TAG, message);
            }

            Intent i = new Intent(Constants.STATUSCONNECTION);
            i.putExtra(Constants.MESSAGE, message);
            context.sendBroadcast(i);
        }
    }
}