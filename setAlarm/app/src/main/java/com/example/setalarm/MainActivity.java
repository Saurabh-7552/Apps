package com.example.setalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            final EditText hour = findViewById(R.id.hour);
            final EditText minute = findViewById(R.id.minute);
            final EditText message = findViewById(R.id.message);
            Button add=findViewById(R.id.click);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()));
                    alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minute.getText().toString()));
                    alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, message.getText().toString());
                    alarmIntent.putExtra(AlarmClock.EXTRA_VIBRATE, true);
                    if (alarmIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(alarmIntent);
                    hour.getText().clear();
                    minute.getText().clear();
                    message.getText().clear();
                }
            });

        }catch (Exception e)
        {
             Intent intent =new Intent(MainActivity.this,errorDisplay.class);
             startActivity(intent);
        }

    }
}