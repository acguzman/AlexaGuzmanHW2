package com.example.alexa.alexaguzmanhw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends Activity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    Button buttonInvCheck;
    Button buttonAddInv;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        buttonAddInv = findViewById(R.id.buttonAddInv);
        buttonInvCheck = findViewById(R.id.buttonInvCheck);
        buttonLogout = findViewById(R.id.buttonLogout);

        buttonAddInv.setOnClickListener(this);
        buttonInvCheck.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.navigationmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Menu item navigation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuItemHome){
            //If menu item selected is current page, display message
            Toast.makeText(this, "Why are you clicking this, you are already at Home!", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.menuItemAddInv) {
            Intent intentProfile = new Intent(this, AddInventory.class);
            startActivity(intentProfile);
        } else if(item.getItemId() == R.id.menuItemCheckInv) {
            Intent intentSetting = new Intent(this, InvCheck.class);
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

        if (v == buttonAddInv){
            Intent intentProfile = new Intent(this, AddInventory.class);
            startActivity(intentProfile);

        } else if (v == buttonInvCheck){
            Intent intentProfile = new Intent(this, InvCheck.class);
            startActivity(intentProfile);

        } else if (v == buttonLogout){
            mAuth.signOut();
            Intent intentProfile = new Intent(this, MainActivity.class);
            startActivity(intentProfile);

        }

    }
}
