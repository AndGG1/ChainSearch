package com.example.chainsearch.features.feature_register.data.data_source.googleRegistration;

import android.content.Context;
import android.os.Build;

import androidx.annotation.Nullable;

import com.example.chainsearch.common.data.utils.data_utils.AuthData;
import com.example.chainsearch.common.data.callbacks.CredentialCallback;
import com.example.chainsearch.common.data.callbacks.IsValidCallback;
import com.example.chainsearch.common.data.utils.functionality_utils.CredentialManagerHelperKt;
import com.example.chainsearch.common.data.utils.functionality_utils.HandleCredentialHelperKt;
import com.example.chainsearch.features.feature_register.data.data_source.helpers.AuthService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class GoogleRegisterAuthService {
    private final FirebaseAuth mAuth;
    private final DatabaseReference databaseRef;
    private final String TEMP_EMPTY_EMAIL = "";

    public GoogleRegisterAuthService(FirebaseAuth mAuth, DatabaseReference databaseRef) {
        this.mAuth = mAuth;
        this.databaseRef = databaseRef;
    }

    public void registerUserWithGoogle(Context context, String username, IsValidCallback callback) {
        boolean isValidVersion = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
        if (!isValidVersion) return;

        HandleCredentialHelperKt.handleCredential(context,
                CredentialManagerHelperKt.getCredentialRequest(),
                new CredentialCallback() {
                    @Override
                    public void onRes(boolean worked, @Nullable String result) {
                        if (worked) {
                                AuthData authData = new AuthData(username, null, databaseRef, mAuth, TEMP_EMPTY_EMAIL);
                                AuthService.registerGoogleEmail(authData, result, callback);
                        } else callback.onRes(false, null);
                    }
                }
        );
    }
}
