package com.example.discodice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean player = true;
    int p1 = 0;
    int p2 = 0;

    // for displaying winner in alert dialog box
   public void winning(int player){
       AlertDialog.Builder win = new AlertDialog.Builder(this);
       win.setTitle("Congrats!");
       win.setMessage("Player " + player + (" Won"));
       win.setIcon(R.drawable.crown);
       win.setNeutralButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               TextView tvPlayer1 = findViewById(R.id.tvScore1);
               tvPlayer1.setText(Integer.toString(0));

               TextView tvPlayer2 = findViewById(R.id.tvScore2);
               tvPlayer2.setText(Integer.toString(0));
           }
       });
       win.show();
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRoll = findViewById(R.id.btRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int dice = random.nextInt(6);
                ImageView ivDice = findViewById(R.id.ivDice1);
                int changeImage = 0;
                switch (dice){
                    case 0: changeImage = R.drawable.dice_1;
                        break;
                    case 1: changeImage = R.drawable.dice_2;
                        break;
                    case 2: changeImage = R.drawable.dice_3;
                        break;
                    case 3: changeImage = R.drawable.dice_4;
                        break;
                    case 4: changeImage = R.drawable.dice_5;
                        break;
                    case 5: changeImage = R.drawable.dice_6;
                        break;
                }
                Toast.makeText(MainActivity.this, (dice+1) + " rolled!", Toast.LENGTH_SHORT).show();
                ivDice.setImageResource(changeImage);
                if(player){
                    p1 = p1 + (dice+1);
                    TextView tvPlayer1 = findViewById(R.id.tvScore1);
                    tvPlayer1.setText(Integer.toString(p1));
                    player = false;
                    if(p1>=15){
                        winning(1);
                        p1 = 0;
                        p2 = 0;
                        player = true;
                    }
                }
                else{
                    p2 = p2 + (dice+1);
                    TextView tvPlayer2 = findViewById(R.id.tvScore2);
                    tvPlayer2.setText(Integer.toString(p2));
                    player = true;
                    if(p2>=15){
                        winning(2);
                        p1 = 0;
                        p2 = 0;
                        player = true;
                    }
                }
            }
        });
    }
}