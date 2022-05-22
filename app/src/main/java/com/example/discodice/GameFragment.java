package com.example.discodice;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;


public class GameFragment extends Fragment{



    public GameFragment() {
        // Required empty public constructor
    }

    View view;
    Button btnRoll;

    boolean player = true;
    int p1 = 0;
    int p2 = 0;

    // restart


    // for displaying winner in alert dialog box

//    TextView tvPlayer1 = view.findViewById(R.id.tvScore1);
//    TextView tvPlayer2 = view.findViewById(R.id.tvScore2);




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {







        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_game,container,false);
        ImageView ivDice = view.findViewById(R.id.ivDice1);
        TextView tvPlayer1 = view.findViewById(R.id.tvScore1);
        TextView tvPlayer2 = view.findViewById(R.id.tvScore2);
        btnRoll = view.findViewById(R.id.btRoll);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int dice = random.nextInt(6);
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
                    default:
                        break;
                }
                Toast.makeText(getActivity(), (dice+1) + " rolled!", Toast.LENGTH_SHORT).show();
                ivDice.setImageResource(changeImage);
                if(player){
                    p1 = p1 + (dice+1);
                    tvPlayer1.setText(Integer.toString(p1));
                    player = false;
                    if(p1>=15){
                        AlertDialog.Builder win = new AlertDialog.Builder(getActivity());
                        win.setTitle("Congrats!");
                        win.setMessage("Player 1 won");
                        win.setIcon(R.drawable.crown);
                        win.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                tvPlayer1.setText(Integer.toString(0));


                                tvPlayer2.setText(Integer.toString(0));
                            }
                        });
                        win.show();
                        p1 = 0;
                        p2 = 0;
                        player = true;
                    }
                }
                else{
                    p2 = p2 + (dice+1);
                    tvPlayer2.setText(Integer.toString(p2));
                    player = true;
                    if(p2>=15){
                        AlertDialog.Builder win = new AlertDialog.Builder(getActivity());
                        win.setTitle("Congrats!");
                        win.setMessage("Player 2 won");
                        win.setIcon(R.drawable.crown);
                        win.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                tvPlayer1.setText(Integer.toString(0));


                                tvPlayer2.setText(Integer.toString(0));
                            }
                        });
                        win.show();
                        p1 = 0;
                        p2 = 0;
                        player = true;
                    }
                }
            }
        });





        return  view;
    }


}