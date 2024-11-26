package com.example.practica021;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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

        ConstraintLayout layoutOval = findViewById(R.id.layoutOval);
        Canva canva = new Canva(this);
        layoutOval.addView(canva);

    }

    static class Canva extends View{
        Canva(Context context) {
            super(context);
        }

        @SuppressLint("DrawAllocation")
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255,255,255);
            int ancho = getWidth();
            int alto = getHeight();
            Paint paint = new Paint();
            paint.setARGB(255, 255, 0, 0);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            RectF rect = new RectF(0, 0, ancho, alto);
            canvas.drawOval(rect, paint);


            // This is to check if is on the upside down
            int min = Math.min(ancho, alto);

            paint.setStyle(Paint.Style.FILL);
            paint.setARGB(255, 0, 0, 255);
            canvas.drawCircle(ancho / 2, alto / 2, min / 2, paint);

        }
    }
}