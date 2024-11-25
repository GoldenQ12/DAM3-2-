package com.example.practica016;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart, btnPause, btnContinue, btnStop, btnNoLoop;
    MediaPlayer mp;
    int position = 0;
    boolean isLoop = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnContinue = findViewById(R.id.btnContinue);
        btnStop = findViewById(R.id.btnStop);
        btnNoLoop = findViewById(R.id.btnNoLoop);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnStart)) {
            Start();
        } else if (v.equals(btnPause)) {
            Pause();
        } else if (v.equals(btnContinue)) {
            Continue();
        } else if (v.equals(btnStop)) {
            Stop();
        } else if (v.equals(btnNoLoop)) {
            NoLoop();
        }
    }

    public void Start(){
        if (mp != null) mp.release();
        mp = MediaPlayer.create(this, R.raw.audio);
        mp.start();
        if (isLoop) {
            mp.setLooping(true);
        } else {
            mp.setLooping(false);
        }

    }

    public void Pause(){
        if (mp != null && mp.isPlaying()) {
            position = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void Continue(){
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(position);
            mp.start();
        }
    }

    public void Stop(){
        if (mp != null) {
            mp.stop();
            position = 0;
        }
    }

    public void NoLoop(){
        Stop();
        if (!isLoop) {
            isLoop = true;
            btnNoLoop.setText("REPRODUCIR EN FORMA CIRCULAR");
        } else {
            isLoop = false;
            btnNoLoop.setText("NO REPRODUCIR EN FORMA CIRCULAR");
        }
    }
}