package com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionsCheck {
    public static List<String> doesItHavePermissions(Context context) {
        //Permissions check
        String[] perms = new String[]{Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE};
        List<String> unauthorizedPerms = new ArrayList<>();

        for (String p : perms) {
            if (ContextCompat.checkSelfPermission(context, p) != PackageManager.PERMISSION_GRANTED) {
                unauthorizedPerms.add(p);
            }
        }

        return unauthorizedPerms;
    }
}