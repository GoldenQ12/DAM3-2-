package com.example.examenprueba;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLInput;
import java.util.ArrayList;

public class ShowDetails extends AppCompatActivity {

    public String DATABASE_NAME = "examen";


    private String id_alumno, id_curso;
    private TextView tv1, tv2, tv3, tv4;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_details);
        id_alumno = getIntent().getStringExtra("DNI");
        id_curso = getIntent().getStringExtra("id_curso");



        tv1 = findViewById(R.id.etField1);
        tv2 = findViewById(R.id.etField2);
        tv3 = findViewById(R.id.etField3);
        tv4 = findViewById(R.id.etField4);

        btnBack = findViewById(R.id.btnBack);

        Load();
    }

    public void volver(View v ) {
        if (v.equals(btnBack)) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
    public void Load() {
        if (!id_alumno.isEmpty()) {
                GetAlumnoByNombre(id_alumno);
            } else {
                GetCursoById(id_curso);
        }
    }

    public void GetAlumnoByNombre(String nombre) {
        try {
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Alumnos WHERE nombre = ?", new String[] { nombre });
            if (cursor.moveToFirst()) {
                do{
                    //etField1.setText(cursor.getString(cursor.getColumnIndex("dni")));
                    //etField2.setText(cursor.getString(cursor.getColumnIndex("nombre")));
                    //etField3.setText(cursor.getInt(cursor.getColumnIndex("edad")));

                    tv1.setText(cursor.getString(0));
                    tv2.setText(cursor.getString(1));
                    tv3.setText(cursor.getString(2));
                    String id_cursoSet = cursor.getString(3);

                    if (id_cursoSet == null || id_cursoSet.isEmpty()) id_cursoSet = "No esta matriculado a ningún curso";
                    tv4.setText(id_cursoSet);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception ex ) {
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void GetCursoById(String id_curso){
        try {
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Cursos WHERE id_curso = ?", new String[] { id_curso });
            if (cursor.moveToFirst()) {
                do{
                    tv1.setText(cursor.getString(0));
                    tv2.setText(cursor.getString(1));
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception ex ) {
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}