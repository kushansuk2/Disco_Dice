package com.example.discodice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity   {



    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle toggle;
    public BottomNavigationView bottomNavigationView;

//    void restart(){
//
//        p1 = p2 = 0;
//
//        TextView tvPlayer1 = findViewById(R.id.tvScore1);
//        tvPlayer1.setText(Integer.toString(0));
//
//        TextView tvPlayer2 = findViewById(R.id.tvScore2);
//        tvPlayer2.setText(Integer.toString(0));
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //splashscreen-----------------------------------------------------------------------------------


        //-----------------------------------------------------------------------------------------------------

         //fragments------------------------------------------------------------------------------------------
        replaceFragment(new GameFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.miDiceStriking);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();
            if(id==R.id.miDiceStriking){
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                replaceFragment(new GameFragment());
            }
            if(id==R.id.miDice){
                replaceFragment(new DiceFragment());
            }
            if(id==R.id.miProfile){
                replaceFragment(new ProfileFragment());
            }

            return true;
        });




        //-----------------------------------------------------------------------------------------------------

//        // slidable menu --------------------------------------------------------------------------------------
        drawerLayout = findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id==R.id.miRestart){
                //restart();
                Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
            }
            if(id==R.id.miNewgame){
                //restart();
                Toast.makeText(this, "New Game", Toast.LENGTH_SHORT).show();
            }if(id==R.id.miAbout){
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            }

            return true;
        });

        // ------------------------------------------------------------------------------------------------




    }


    // fragments -------------------------------
        private void replaceFragment(Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,fragment).commit();
        }
    //------------------------------------------


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // menu
        if(toggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }





//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//    }


}