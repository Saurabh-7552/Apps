package com.example.german;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {
   private MediaPlayer mSound;
   private AudioManager audioManager;

    final AudioManager.OnAudioFocusChangeListener mAudioChangeListener =new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
            {
                if(mSound !=null)
                    mSound.start();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMedia();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                if(mSound !=null)
                    mSound.pause();
                mSound.seekTo(0);
            }

        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);


        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final List<Word> getWords =createNumber();
        WordAdapter arrayAdapter =new WordAdapter(this,getWords,R.color.category_numbers);
        ListView listView =findViewById(R.id.rootView);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {   releaseMedia();
                        int result=audioManager.requestAudioFocus(mAudioChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                        if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                        {
                            mSound =MediaPlayer.create(NumbersActivity.this, getWords.get(position).getSoundResource());
                            mSound.start();
                            mSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    releaseMedia();
                                }
                            });
                        }

                    }
                });


    }
    private List<Word> createNumber()
    {   final List<Word> words =new ArrayList<>();
        words.add(new Word("Null","Zero",R.drawable.digit_zero,R.raw.zero));
        words.add(new Word("Ein","One",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Zwei","Two",R.drawable.digit_two,R.raw.two));
        words.add(new Word("Drei","Three",R.drawable.digit_three,R.raw.three));
        words.add(new Word("Vier","Four",R.drawable.digit_four,R.raw.four));
        words.add(new Word("Funf","Five",R.drawable.digit_five,R.raw.five));
        words.add(new Word("Sechs","Six",R.drawable.digit_six,R.raw.six));
        words.add(new Word("Sieben","Seven",R.drawable.digit_seven,R.raw.seven));
        words.add(new Word("Acht","Eight",R.drawable.digit_eight,R.raw.eight));
        words.add(new Word("Neun","Nine",R.drawable.digit_nine,R.raw.nine));
        words.add(new Word("Zehn","Ten",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Elf","Eleven",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Zwolf","Twelve",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Dreizehn","Thirteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Vierzehn","Fourteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Funfzehn","Fifteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Sechzehn","Sixteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Siebzehn","Seventeen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Achtzehn","Eighteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Neunzehn","Nineteen",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Zwanzig","Twenty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Einundzwanzig","Twenty One",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Zweiundzwanzig","Twenty Two",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Neunundzwanzig","Twenty Two",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Dreiundzwanzig","Twenty Three",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Vierundzwanzig","Twenty Four",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Funfundzwanzig","Twenty Five",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Sechsundzwanzig","Twenty Six",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Siebenundzwanzig","Twenty Seven",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Achtundzwanzig","Twenty Eight",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Neunundzwanzig","Twenty Nine",R.drawable.digit_one,R.raw.one));
        words.add(new Word("DreiBig","Thirty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Vierzig","Forty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("funfzig","Fifty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Sechzig","Sixty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Siebzig","Seventy",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Achtzig","Eighty",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Neunzig","Ninety",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Hundert","Hundred",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Vierhundertzweiundfunfzig","Four Hundred fifty Two",R.drawable.digit_one,R.raw.one));
        words.add(new Word("Tausand","Thousand",R.drawable.digit_one,R.raw.one));

        Log.v("NumberActivity","words are shown");

        return words;
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
    public void releaseMedia()
    {
        if(mSound !=null)
            mSound.release();

        mSound =null;
        audioManager.abandonAudioFocus(mAudioChangeListener);
    }

}