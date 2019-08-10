package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {


//    public void Mediate() throws IOException{
//        mediaPlayer.start();
//
////        Uri myUri = Uri.fromFile(new File("Innocence.wav")); // initialize Uri here
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
////        mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        mediaPlayer.prepare();
//        mediaPlayer.start();
//    }
    public int placeholder =0;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);

        String[] songs = {"innocence", "klondike"};
        final int[] resID = {R.raw.innocence, R.raw.klondike};

        mediaPlayer = MediaPlayer.create(this, resID[placeholder]);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();

            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                placeholder++;
                if(placeholder<resID.length) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), resID[placeholder]);
                    mediaPlayer.start();
                }
                else{
                    placeholder =0;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), resID[placeholder]);
                    mediaPlayer.start();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                placeholder--;
                if(placeholder>=0) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), resID[placeholder]);
                    mediaPlayer.start();
                }
                else{
                    placeholder =0;
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), resID[placeholder]);
                    mediaPlayer.start();
                }
            }
        });




    }
}
