package com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetCheck {
    public static boolean doesItHaveInternet(Context context) {
        //Internet & Network State check
        boolean hasInternet = true;
        ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnectedOrConnecting()) {
            hasInternet = false;
        }

        return hasInternet;
    }
}