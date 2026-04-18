package com.example.chainsearch.initialAction.auth.registerFunctionality;
import static com.example.chainsearch.initialAction.auth.helpers.RegisterAuthServiceHelperKt.addNewUser;
import static com.example.chainsearch.initialAction.auth.helpers.RegisterAuthServiceHelperKt.isBuildVersionValid;
import static com.example.chainsearch.initialAction.auth.helpers.RegisterAuthServiceHelperKt.isCallbackNull;

import com.example.chainsearch.initialAction.auth.callbacks.IsValidCallback;
import com.example.chainsearch.initialAction.auth.helpers.AuthData;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterAuthService {
    private final FirebaseAuth mAuth;
    private final DatabaseReference databaseRef;

    public RegisterAuthService(FirebaseAuth mAuth, DatabaseReference databaseRef) {
        this.mAuth = mAuth;
        this.databaseRef = databaseRef;
    }

    public void registerEmail(String email, String password, String username, IsValidCallback callback) {
        if (isCallbackNull(callback)) {
            callback = new IsValidCallback() {
                @Override
                public void onRes(boolean isValid, String uid) {

                }
            };
        }

        if (isBuildVersionValid()) {
            callback.onRes(false, null);
            return;
        }

        IsValidCallback finalCallback = callback;
        AuthData authData = new AuthData(username, null, databaseRef, mAuth);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    decideWhetherYouAddUserOrNot(task, authData, finalCallback);
                });
    }

    private void decideWhetherYouAddUserOrNot(Task<?> task, AuthData authData, IsValidCallback finalCallback) {
        if (task.isSuccessful()) {
            addNewUser(authData, finalCallback);
        } else {
            finalCallback.onRes(false, null);
        }
    }
}
