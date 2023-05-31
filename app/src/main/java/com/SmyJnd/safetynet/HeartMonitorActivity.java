package com.SmyJnd.safetynet;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeartMonitorActivity extends AppCompatActivity {
    private TextView bpmValue;
    private Button startButton, stopButton;
    private Handler handler;
    private Runnable runnable;
    private Bundle savedInstanceState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_monitor);

        bpmValue = findViewById(R.id.bpm_value);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int bpm = (int) (Math.random() * 41) + 60; // Generate a random heart rate value between 60 and 100
                bpmValue.setText(String.valueOf(bpm));
                handler.postDelayed(this, 1000); // Schedule the next update after 1 second
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(runnable); // Start updating the heart rate value every second
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable); // Stop updating the heart rate value
                bpmValue.setText("0"); // Reset the heart rate value to 0
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }}