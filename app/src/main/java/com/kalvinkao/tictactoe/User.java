package com.kalvinkao.tictactoe;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String name;
    private FirebaseFirestore db;

    User(FirebaseFirestore db) {
        this.db = db;
    }

    public User(String name) {
        this.name = name;
    }

}
