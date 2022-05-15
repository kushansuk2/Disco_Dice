package com.example.discodice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class DiceFragment extends Fragment {


    public DiceFragment() {
        // Required empty public constructor
    }


   View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dice, container, false);
        ImageView ivDice = view.findViewById(R.id.ivDice1);
        Button btnRoll = view.findViewById(R.id.btRoll);


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
            }
        });


        return view;
    }
}