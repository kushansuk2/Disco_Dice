package com.example.discodice;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;


public class DiceFragment extends Fragment {


    public DiceFragment() {
        // Required empty public constructor
    }


    View view;
    private SensorManager mSensorManager;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dice, container, false);
        Button btnRoll = view.findViewById(R.id.btRoll);
        ImageView ivDice = view.findViewById(R.id.ivDice1);



        // shake sensor ------------------------------------------------------------------
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        //-----------------------------------------------------------------------------------


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

    private final SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) ( x*x + y*y +  z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;
            if (mAccel > 20) {
                //Toast.makeText(getActivity(), "Shake event detected", Toast.LENGTH_SHORT).show();
                ImageView ivDice = view.findViewById(R.id.ivDice1);
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
                //Toast.makeText(getActivity(), (dice+1) + " rolled!", Toast.LENGTH_SHORT).show();
                ivDice.setImageResource(changeImage);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    public void onResume() {
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }

}