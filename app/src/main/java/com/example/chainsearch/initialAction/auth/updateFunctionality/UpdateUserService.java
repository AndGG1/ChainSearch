//package com.example.chainsearch.initialAction.auth.updateFunctionality;
//
//import androidx.annotation.NonNull;
//
//import com.example.chainsearch.initialAction.auth.User;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.ValueEventListener;
//
//public class UpdateUserService {
//public void updateUser(String uid, String username, IsValidCallback callback, Object... objArr) {
//    callback = callback == null ? new IsValidCallback() {
//        @Override
//        public void onRes(boolean isValid, String uid) {
//
//        }
//    } : callback;
//
//    IsValidCallback finalCallback = callback;
//    databaseRef.child("users").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot snapshot) {
//            String newDate = null;
//            double newAvg = -1.0;
//            int newClicks = -1;
//
//            for (Object data : objArr) {
//                if (data instanceof String) {
//                    newDate = (String) data;
//                } else if (data instanceof Double) {
//                    newAvg = (double) data;
//                } else if (data instanceof Integer) {
//                    newClicks = (int) data;
//                }
//            }
//
//            var iterator = snapshot.getChildren().iterator();
//            boolean flag = false;
//            while (iterator.hasNext()) {
//                var val = iterator.next().getValue();
//                if (val instanceof String && flag) {
//                    newDate = newDate == null ? (String) val : newDate;
//                } else if (val instanceof Double) {
//                    newAvg = newAvg == -1.0 ? (double) val : newAvg;
//                } else if (val instanceof Integer) {
//                    newClicks = newClicks == -1 ? (int) val : newClicks;
//                }
//                flag = true;
//            }
//
//            User updatedUser = new User(
//                    username,
//                    newDate,
//                    newAvg,
//                    newClicks
//            );
//
//            addUser(username, uid, finalCallback, updatedUser);
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//            finalCallback.onRes(false, uid);
//        }
//    });
//}