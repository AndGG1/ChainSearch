package com.example.chainsearch.initialAction.loadingPack;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.core.content.ContextCompat;

import com.example.chainsearch.initialAction.viewModels.states.ExternalListener;
import com.example.chainsearch.initialAction.viewModels.states.InternalListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.flow.MutableStateFlow;

public class LoadingChecks {
    //TODO: Add Firebase external check + API external check!!!
    public static ExternalListener checkExteriorEnv(Context context, double minimumFreeGB) {
        //Internet & Network State check
        boolean hasInternet = true;
        ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnectedOrConnecting()) {
            hasInternet = false;
        }

        //Permissions check
        String[] perms = new String[]{Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE};
        List<String> unauthorizedPerms = new ArrayList<>();

        for (String p : perms) {
            if (ContextCompat.checkSelfPermission(context, p) != PackageManager.PERMISSION_GRANTED) {
                unauthorizedPerms.add(p);
            }
        }

        //Available Storage check
        boolean hasEnoughSpace = false;
        File storageFile = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(storageFile.getPath());
        long freeBytes = stat.getAvailableBytes();
        if (freeBytes >= (minimumFreeGB * 1024L * 1024L * 1024L)) {
            hasEnoughSpace = true;
        }

        ExternalListener ex = new ExternalListener(hasInternet, unauthorizedPerms, hasEnoughSpace);
        return ex;
    }

    //TODO: Add Database internal check!!!
    public static InternalListener checkInternalEnv(View rootView, MutableStateFlow<Boolean> stateFlow) {
        rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                stateFlow.setValue(true);
                return true;
            }
        });

        //TODO: Complete this when Database Impl. is ready!!!
        return new InternalListener(true);
    }
}
