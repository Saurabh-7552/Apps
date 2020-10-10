package com.example.musicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private SeekBar mSeekBar;
    int max=0;
    int current=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer myNumbers=MediaPlayer.create(this,R.raw.matargashti);
        Button playButton = findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myNumbers.start();
                Toast.makeText(MainActivity.this,"Starting the Song",Toast.LENGTH_SHORT).show();
            }
        });
        Button pauseButton = findViewById(R.id.pause);
        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myNumbers.pause();
            }
        });
        Button stopButton = findViewById(R.id.stop);
        stopButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              myNumbers.stop();
                                              try {
                                                  myNumbers.prepare();
                                              }catch (Exception e)
                                              {
                                                  System.out.println(e.getMessage());
                                              }
                                          }
                                      }
        );
        myNumbers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this,"I'm Done",Toast.LENGTH_SHORT).show();
               releaseMediaPlayer(mediaPlayer);
            }
        });
    }

    private void releaseMediaPlayer(MediaPlayer mMediaPlayer) {

        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
           mMediaPlayer=null;
        }
    }

}