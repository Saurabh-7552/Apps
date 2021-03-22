package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int Seconds = 0;
    private Boolean Running = false, wasRunning = false;
    private TextView timeTextView;

    @Override
    protected void onResume() {
        if (wasRunning) Running = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        wasRunning = Running;
        Running = false;
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            Seconds = savedInstanceState.getInt("mySecondSaved");
            Running = savedInstanceState.getBoolean("myRunningSaved");
            wasRunning = savedInstanceState.getBoolean("myWasRunning");
        }

        timeTextView = findViewById(R.id.time);
        Button startButton = findViewById(R.id.startButton);
        Button stopButton = findViewById(R.id.stopButton);
        Button resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(v -> {
            Running = false;
            Seconds = 0;
        });

        stopButton.setOnClickListener(v -> Running = false);
        startButton.setOnClickListener(v -> Running = true);
        runTime();
    }

    public void runTime() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = Seconds / 3600;
                int minutes = (Seconds % 3600) / 60;
                int seconds = Seconds % 60;
                String myTime = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, seconds);
                timeTextView.setText(myTime);
                if (Running) {
                    ++Seconds;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("mySecondSaved", Seconds);
        outState.putBoolean("myRunningSaved", Running);
        outState.putBoolean("myWasRunning", wasRunning);
        super.onSaveInstanceState(outState);
    }
}