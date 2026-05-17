package com.example.chainsearch.features.feature_register.data.data_source.helpers;

import com.example.chainsearch.common.data.utils.data_utils.AuthData;
import com.example.chainsearch.common.data.callbacks.IsValidCallback;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import static com.example.chainsearch.common.data.utils.functionality_utils.RegisterAuthServiceHelperKt.addNewUser;

import java.util.Objects;

public class AuthService {
    public static void registerGoogleEmail(AuthData authData, String result, IsValidCallback callback) {
        AuthCredential credential = GoogleAuthProvider.getCredential(result, null);
        authData.getMAuth().signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String email = Objects.requireNonNull(task.getResult().getUser()).getEmail();
                        assert email != null;
                        AuthData newAuthData = new AuthData(
                                authData.getUsername(),
                                authData.getUid(),
                                authData.getDatabaseRef(),
                                authData.getMAuth(),
                                email
                        );

                        decideWhetherYouAddUserOrNotGoogle(task, newAuthData, new IsValidCallback() {
                            @Override
                            public void onRes(boolean isValid, String uid) {
                                callback.onRes(isValid, uid);
                            }
                        });
                    } else callback.onRes(false, null);
                });
    }

    private static void decideWhetherYouAddUserOrNotGoogle(Task<?> task, AuthData authData, IsValidCallback callback) {
        if (task.isSuccessful()) {
            isGoogleEmailAlreadyAdded(authData, new IsValidCallback() {
                @Override
                public void onRes(boolean isValid, String uid) {
                    if (isValid) {
                        callback.onRes(false, null);
                    } else {
                        addNewUser(authData, callback);
                        callback.onRes(true, authData.getUid());
                    }
                }
            });
        } else {
            callback.onRes(false, null);
        }
    }

    private static void isGoogleEmailAlreadyAdded(AuthData authData, IsValidCallback callback) {
        authData.getMAuth().fetchSignInMethodsForEmail(authData.getEmail())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        boolean exists = !Objects.requireNonNull(task.getResult().getSignInMethods()).isEmpty();
                        callback.onRes(exists, authData.getUid());
                    } else {
                        callback.onRes(false, null);
                    }
                });
    }
}