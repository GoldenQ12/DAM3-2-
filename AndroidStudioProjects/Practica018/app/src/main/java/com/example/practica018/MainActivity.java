package com.example.practica018;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.layout1);
        Canva canva = new Canva(this);
        layout.addView(canva);

    }

    class Canva extends View {
        public Canva(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {

            int ancho = canvas.getWidth();
            canvas.drawRGB(255,255, 0);
            Paint paint = new Paint();
            paint.setARGB(255,255,0,0);
            canvas.drawLine(0,30, ancho, 30, paint);
            paint.setStrokeWidth(5);
            canvas.drawLine(0, 60, ancho, 60, paint);

        }
    }
}