package com.example.chainsearch.initialAction.loadingPack.helpers.LoadingChecksHelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectedToFirebaseCheck {
    public static void isConnected(AtomicBoolean atomicBoolean) {
        FirebaseDatabase.getInstance().getReference(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class) != null
                        && Boolean.TRUE.equals(snapshot.getValue(Boolean.class));
                atomicBoolean.set(connected);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                atomicBoolean.set(false);
            }
        });
    }
}
