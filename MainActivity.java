package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
//        pause = findViewById(R.id.pause);
        seekBar = findViewById(R.id.seekBar);

        // Play music using local source
        final MediaPlayer mediaPlayer = new MediaPlayer().create(this, R.raw.desikalakaar);

        // Play music using remote source
        // MediaPlayer mediaPlayer1 = new MediaPlayer();
        // try {
        //    mediaPlayer1.setDataSource("https://google.com");
        // } catch (IOException e) {
        //    e.printStackTrace();
        // }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.setLooping(true);
                    play.setText("Play");
                } else {
                    mediaPlayer.start();
                    play.setText("Pause");
                }
            }

        });

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



















    }
}