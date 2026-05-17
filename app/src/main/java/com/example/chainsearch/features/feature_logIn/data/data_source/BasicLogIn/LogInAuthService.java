package com.example.chainsearch.features.feature_logIn.data.data_source.BasicLogIn;

import static com.example.chainsearch.common.data.utils.functionality_utils.RegisterAuthServiceHelperKt.addNewUser;
import static com.example.chainsearch.common.data.utils.functionality_utils.RegisterAuthServiceHelperKt.isBuildVersionValid;
import static com.example.chainsearch.common.data.utils.functionality_utils.RegisterAuthServiceHelperKt.obtainUsername;

import com.example.chainsearch.common.data.callbacks.IsValidCallback;
import com.example.chainsearch.common.data.utils.data_utils.AuthData;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class LogInAuthService {
    private final FirebaseAuth mAuth;
    private final DatabaseReference databaseRef;

    public LogInAuthService(FirebaseAuth mAuth, DatabaseReference databaseRef) {
        this.mAuth = mAuth;
        this.databaseRef = databaseRef;
    }

    public void logInWithEmail(String email, String password, IsValidCallback callback) {
        if (isBuildVersionValid()) {
            callback.onRes(false, null);
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    AuthData authData = new AuthData(
                            "",
                            Objects.requireNonNull(task.getResult().getUser()).getUid(),
                            databaseRef,
                            mAuth,
                            email
                    );
                    decideWhetherYouUpdateUserOrNot(task, authData, callback);
                } else callback.onRes(false, null);
            });
    }

    private void decideWhetherYouUpdateUserOrNot(Task<?> task, AuthData authData, IsValidCallback finalCallback) {
        if (task.isSuccessful()) {
            obtainUsername(authData, username -> {
                if (username != null && !username.isEmpty()) {
                    AuthData newAuthData = new AuthData(
                            username,
                            authData.getUid(),
                            authData.getDatabaseRef(),
                            authData.getMAuth(),
                            authData.getEmail()
                    );
                    addNewUser(newAuthData, finalCallback);
                }
            });
        } else {
            finalCallback.onRes(false, null);
        }
    }
}