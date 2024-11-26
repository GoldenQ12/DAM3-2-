package com.example.practica020;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ConstraintLayout layoutCircle = findViewById(R.id.layoutCircle);
        Canva canva = new Canva(this);
        layoutCircle.addView(canva);

    }

    static class Canva extends View{
        Canva(Context context) {
            super(context);
        }

        @SuppressLint("DrawAllocation")
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 255);
            int ancho = getWidth();
            int alto = getHeight();
            Paint paint = new Paint();
            paint.setARGB(255,255,0,0);
            paint.setStyle(Paint.Style.STROKE);
            for (int i = 0; i < 10; i++) {
                canvas.drawCircle(ancho / 2, alto / 2, i * 20, paint);
            }
        }
    }
}