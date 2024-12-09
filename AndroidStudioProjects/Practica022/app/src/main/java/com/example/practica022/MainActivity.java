package com.example.practica022;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout layout1 =  findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }

}


class Lienzo extends View {

    public Lienzo(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(0, 0, 255);
        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(50);
        pincel1.setTypeface(Typeface.SERIF);
        canvas.drawText("Hola Mundo (SERIF)", 0, 70, pincel1);
        pincel1.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Hola Mundo (SANS SERIF)", 0, 100, pincel1);
        pincel1.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("Hola Mundo (MONOSPACE)", 0, 140, pincel1);
        Typeface tf = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
        pincel1.setTypeface(tf);
        canvas.drawText("Hola Mundo (SERIF ITALIC)", 0, 180, pincel1);
        tf = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);
        pincel1.setTypeface(tf);
        canvas.drawText("Hola Mundo (SERIF ITALIC BOLD)", 0, 220, pincel1);
    }
}
