package com.example.alexa.alexaguzmanhw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends Activity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    Button buttonLogin, buttonRegister;
    EditText editTextLogin, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonRegister) {
            mAuth.createUserWithEmailAndPassword(editTextLogin.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Welcome New User", Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();

                                // ...
                            }
                        }
                    });
        } else if (v == buttonLogin) {
            final Intent intentProfile = new Intent(this, HomeScreen.class);

            mAuth.signInWithEmailAndPassword(editTextLogin.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Login Successful:" + user.getEmail(), Toast.LENGTH_SHORT).show();

                                //Go to Home Screen if login successful

                                startActivity(intentProfile);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Access Denied", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });


        }
    }
}
