package com.kalvinkao.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Profile extends FragmentActivity {

    GoogleSignInClient mGoogleSignInClient;
    @SuppressLint("StaticFieldLeak")
    static Button sign_out, lb, mm;
    Button btn_back;
    TextView nameTV;
    ImageView photoIV;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        sign_out = findViewById(R.id.log_out);
        mm = findViewById(R.id.btn_mm);
        lb = findViewById(R.id.btn_lb);
        nameTV = findViewById(R.id.name);
        photoIV = findViewById(R.id.photo);
        btn_back = findViewById(R.id.btn_back);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Profile.this);
        if (acct != null) {
            String personName = acct.getGivenName();
            Uri personPhoto = acct.getPhotoUrl();
            nameTV.setText(personName);
            writeNewUser(acct.getId(), personName);
            Glide.with(this).load(personPhoto).into(photoIV);
        }

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction().addToBackStack(Profile.class.getName())
                            .add(android.R.id.content, new Matchmaking()).commit();
                }
                mm.setClickable(false);
                lb.setClickable(false);
                sign_out.setClickable(false);
            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction().addToBackStack(Profile.class.getName())
                            .add(android.R.id.content, new Leaderboard()).commit();
                }
                sign_out.setClickable(false);
            }
        });
    }

    private void writeNewUser(String userId, String name) {
        Map<String, Object> user = new HashMap<>();
        user.put("Name", name);
        user.put("User ID", userId);

        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error writing document", e);
                    }
                });
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Profile.this, "Successfully signed out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Profile.this, Login.class));
                        finish();
                    }
                });
    }
}