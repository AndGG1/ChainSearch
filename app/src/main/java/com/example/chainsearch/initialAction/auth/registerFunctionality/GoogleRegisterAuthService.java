package com.example.chainsearch.initialAction.auth.registerFunctionality;

import android.content.Context;
import android.os.Build;

import androidx.annotation.Nullable;

import com.example.chainsearch.initialAction.auth.callbacks.CredentialCallback;
import com.example.chainsearch.initialAction.auth.helpers.AuthData;
import com.example.chainsearch.initialAction.auth.helpers.credentialHelpers.AuthService;
import com.example.chainsearch.initialAction.auth.helpers.credentialHelpers.CredentialManagerHelperKt;
import com.example.chainsearch.initialAction.auth.helpers.credentialHelpers.HandleCredentialHelperKt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class GoogleRegisterAuthService {
    private final FirebaseAuth mAuth;
    private final DatabaseReference databaseRef;

    public GoogleRegisterAuthService(FirebaseAuth mAuth, DatabaseReference databaseRef) {
        this.mAuth = mAuth;
        this.databaseRef = databaseRef;
    }

    public void registerUserWithGoogle(Context context) {
        boolean isValidVersion = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
        if (!isValidVersion) return;

        HandleCredentialHelperKt.handleCredential(context,
                CredentialManagerHelperKt.getCredentialRequest(),
                new CredentialCallback() {
                    @Override
                    public void onRes(boolean worked, @Nullable String result) {
                        if (worked) {
                            AuthData authData = new AuthData("test_13", null, databaseRef, mAuth);
                            AuthService.registerGoogleEmail(authData, result);
                        }
                    }
                }
        );
    }
}
