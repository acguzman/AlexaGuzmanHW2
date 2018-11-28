package com.example.alexa.alexaguzmanhw2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class InvCheck extends Activity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    Button buttonHomeInvCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_check);

        buttonHomeInvCheck = findViewById(R.id.buttonHomeInvCheck);

        buttonHomeInvCheck.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navigationmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuItemCheckInv){
            Toast.makeText(this, "Why are you clicking this, you are already at Inventory Check!", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.menuItemHome) {
            Intent intentProfile = new Intent(this, HomeScreen.class);
            startActivity(intentProfile);
        } else if(item.getItemId() == R.id.menuItemAddInv) {
            Intent intentSetting = new Intent(this, AddInventory.class);
            startActivity(intentSetting);
        } else if(item.getItemId() == R.id.menuItemLogout) {
            mAuth.signOut();
            Intent intentSetting = new Intent(this, MainActivity.class);
            startActivity(intentSetting);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intentProfile = new Intent(this, HomeScreen.class);
        startActivity(intentProfile);
    }
}
