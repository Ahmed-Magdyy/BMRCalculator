package com.example.ahmedmagdy.countdown;

import android.content.Intent;

import java.text.SimpleDateFormat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public Button calculateBtn;
    public Button incrementW;
    public Button decrementW;
    public Button incrementA;
    public Button decrementA;
    public TextView ageText;
    public TextView weightText;
    public TextView heightText;
    public TextView bmrTextView;
    public SeekBar seekBar;
    public int weight = 60;
    public int height = 160;
    public int age = 20;
    public String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBarID);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                heightText = (TextView) findViewById(R.id.heightTextView);
                height = progress;
                heightText.setText(String.valueOf(height));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void incrementWeight(View view) {
        weightText = (TextView) findViewById(R.id.WeightTextView);
        incrementW = (Button) findViewById(R.id.incrementWeightID);
        String weightString = weightText.getText().toString();
        weight = Integer.parseInt(weightString);
        weight++;
        weightText.setText(String.valueOf(weight));
    }

    public void decrementWeight(View view) {
        weightText = (TextView) findViewById(R.id.WeightTextView);
        decrementW = (Button) findViewById(R.id.decrementWeightID);
        String weightString = weightText.getText().toString();
        weight = Integer.parseInt(weightString);
        weight--;
        weightText.setText(String.valueOf(weight));
    }

    public void incrementAge(View view) {
        ageText = (TextView) findViewById(R.id.AgetTextView);
        incrementA = (Button) findViewById(R.id.incrementAgeID);
        String ageString = ageText.getText().toString();
        age = Integer.parseInt(ageString);
        age++;
        ageText.setText(String.valueOf(age));
    }

    public void decrementAge(View view) {
        ageText = (TextView) findViewById(R.id.AgetTextView);
        decrementA = (Button) findViewById(R.id.decrementAgeID);
        String ageString = ageText.getText().toString();
        age = Integer.parseInt(ageString);
        age--;
        ageText.setText(String.valueOf(age));
    }

    public void maleSelected(View view) {
        gender = "male";
        
    }

    public void femaleSelected(View view) {
        gender = "female";
    }

    public void calculateBMR(View view) {
        bmrTextView = (TextView) findViewById(R.id.BMRtTextView);
        if (gender == "male") {
            double BMR = (double) Math.round((66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age)) * 100) / 100;
            bmrTextView.setText("BMR = " + String.valueOf(BMR) + " Calories");
        } else if (gender == "female") {
            double BMR = (double) Math.round((655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age)) * 100) / 100;
            bmrTextView.setText("BMR = " + String.valueOf(BMR) + " Calories");
        } else
            Toast.makeText(this, "You forgot to select the gender", Toast.LENGTH_LONG).show();


    }

}
