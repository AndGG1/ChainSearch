package com.example.chainsearch.initialAction.loadingPack;

import android.content.Context;
import com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper.InternetCheck;
import com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper.MemoryCheck;
import com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper.PermissionsCheck;
import com.example.chainsearch.initialAction.viewModels.states.ExternalListener;
import com.example.chainsearch.initialAction.viewModels.states.InternalListener;

import java.util.List;

public class LoadingChecks {
    //TODO: Add Firebase external check + API external check!!!
    public static ExternalListener checkExteriorEnv(Context context, double percentage) {
        boolean hasInternet = InternetCheck.doesItHaveInternet(context);
        List<String> unauthorizedPerms = PermissionsCheck.doesItHavePermissions(context);
        boolean hasEnoughSpace = MemoryCheck.doesItHaveEnoughMemory(context, percentage);


        return new ExternalListener(
                hasInternet, unauthorizedPerms, hasEnoughSpace);
    }

    //TODO: Add Database internal check!!!
    public static InternalListener checkInternalEnv() {
        return new InternalListener(true);
    }
}