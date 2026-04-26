package com.example.chainsearch.initialAction.auth.helpers.credentialHelpers;

import com.example.chainsearch.initialAction.auth.callbacks.IsValidCallback;
import com.example.chainsearch.initialAction.auth.helpers.AuthData;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import static com.example.chainsearch.initialAction.auth.helpers.RegisterAuthServiceHelperKt.addNewUser;

public class AuthService {
    public static void registerGoogleEmail(AuthData authData, String result) {
        AuthCredential credential = GoogleAuthProvider.getCredential(result, null);
        authData.getMAuth().signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    decideWhetherYouAddUserOrNotGoogle(task, authData, new IsValidCallback() {
                        @Override
                        public void onRes(boolean isValid, String uid) {

                        }
                    });
                });
    }

    private static void decideWhetherYouAddUserOrNotGoogle(Task<?> task, AuthData authData, IsValidCallback callback) {
        if (task.isSuccessful()) {
            addNewUser(authData, callback);
        } else {
            callback.onRes(false, null);
        }
    }
}