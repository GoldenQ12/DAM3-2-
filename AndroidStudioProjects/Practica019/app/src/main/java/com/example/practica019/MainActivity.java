package com.example.practica019;

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

        ConstraintLayout layoutRectangulo = findViewById(R.id.layoutRectangulo);
        Canva canva = new Canva(this);
        layoutRectangulo.addView(canva);

    }

    static class Canva extends View{
        Canva(Context context) {
            super(context);
        }

        @SuppressLint("DrawAllocation")
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 255);
            int ancho = getWidth();
            Paint paint = new Paint();

            paint.setARGB(255, 255, 0, 0);
            canvas.drawRect(10, 10, ancho - 10, 40, paint);

            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(10, 60, ancho - 10, 90, paint);

            paint.setStrokeWidth(5);
            canvas.drawRect(10, 110, ancho - 10, 150, paint);
        }
    }
}