package com.example.examenprueba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class updateView extends AppCompatActivity implements View.OnClickListener {

    public String DATABASE_NAME = "examen";

    private TextView tvTitle;
    private Button btnShow, btnUpdate;
    private RadioButton rbAlumnos, rbCursos;
    private EditText etField1, etField2, etField3, etField4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_view);

        btnShow = findViewById(R.id.btnShow);
        btnUpdate = findViewById(R.id.btnBack);

        rbAlumnos = findViewById(R.id.rbAlumnos);
        rbCursos = findViewById(R.id.rbCursos);

        etField1 = findViewById(R.id.etField1);
        etField2 = findViewById(R.id.etField2);
        etField3 = findViewById(R.id.etField3);
        etField4 = findViewById(R.id.etField4);

        tvTitle = findViewById(R.id.tvTitle);

        btnShow.setOnClickListener(this);
        rbAlumnos.setOnClickListener(this);
        rbCursos.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnShow)) {
            if (rbAlumnos.isChecked()) {
                ObtenerDatosAlumnoById(etField1.getText().toString());
            } else if (rbCursos.isChecked()) {
                ObtenerDatosCursoById(etField1.getText().toString());
            }
        } else if (v.equals(rbAlumnos)) {
            AlumnosInfo();
        } else if (v.equals(rbCursos)) {
            CursosInfo();
        } else if (v.equals(btnUpdate)) {
            if (rbAlumnos.isChecked()) {
                Alumnos(etField1.getText().toString());
            } else if (rbCursos.isChecked()) {
                Cursos(etField1.getText().toString());
            }
        }
    }

    private void AlumnosInfo(){

        etField1.setText("");
        etField2.setText("");
        etField3.setText("");
        etField4.setText("");
        tvTitle.setText("ALUMNOS");

        etField1.setHint("Introduce el DNI...");
        etField2.setHint("Introduce el nombre...");
        etField3.setHint("Introduce la edad...");
        etField4.setHint("Introduce el identificador del curso... ( si esta cursando ) ");

        etField3.setVisibility(View.VISIBLE);
        etField4.setVisibility(View.VISIBLE);
    }

    private void CursosInfo(){
        tvTitle.setText("CURSOS");
        etField1.setHint("Introduce el identificador del curso...");
        etField2.setHint("Introduce el nombre del curso...");

        etField3.setVisibility(View.INVISIBLE);
        etField4.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("Range")
    public ArrayList<String> ObtenerDatosAlumnoById (String dni) {
        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ArrayList<String> alumno = new ArrayList<>();
            //ContentValues alumnoInfo = new ContentValues();
            //alumnoInfo.put("dni", etField1.getText().toString());
            //alumnoInfo.put("nombre", etField2.getText().toString());
            //alumnoInfo.put("edad", etField3.getText().toString());
            //alumnoInfo.put("id_curso", etField4.getText().toString());
            //db.update("Alumnos", alumnoInfo, dni, dni);
            Cursor cursor = db.rawQuery("SELECT * FROM Alumnos WHERE dni = '" + dni + "'", null);
            if (cursor.moveToFirst()) {
                do{
                    //etField1.setText(cursor.getString(cursor.getColumnIndex("dni")));
                    //etField2.setText(cursor.getString(cursor.getColumnIndex("nombre")));
                    //etField3.setText(cursor.getInt(cursor.getColumnIndex("edad")));

                    etField1.setText(cursor.getString(0));
                    etField2.setText(cursor.getString(1));
                    etField3.setText(cursor.getString(2));
                    String id_cursoSet = cursor.getString(3);

                    if (id_cursoSet == null || id_cursoSet.isEmpty()) id_cursoSet = "No esta matriculado a ningún curso";
                    etField4.setText(id_cursoSet);
                } while (cursor.moveToNext());
            }
            cursor.close();
            return alumno;
        } catch (Exception ex ) {
            Toast.makeText(this, "Ha ocurrido un error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    public ArrayList<String> ObtenerDatosCursoById (String id_curso) {
        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ArrayList<String> curso = new ArrayList<>();
            Cursor cursor = db.rawQuery("SELECT * FROM Cursos WHERE id_curso = ?", new String[] { id_curso });
            if (cursor.moveToFirst()) {
                do{
                    etField1.setText(cursor.getString(0));
                    etField2.setText(cursor.getString(1));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return curso;
        } catch (Exception ex ) {
            Toast.makeText(this, "Ha ocurrido un error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return null;
    }

    private void Alumnos(String dni) {

        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues alumno = new ContentValues();
            alumno.put("dni", etField1.getText().toString());
            alumno.put("nombre", etField2.getText().toString());
            alumno.put("edad", etField3.getText().toString());
            alumno.put("id_curso", etField4.getText().toString());
            //db.execSQL("UPDATE Alumnos SET dni = '" + etField1.getText().toString() + "', nombre = '" + etField2.getText().toString() + "' WHERE dni = '" + dni + "'");
            db.update("Alumnos", alumno, "dni = '" + dni + "'", null);
            etField1.setText("");
            etField2.setText("");
            etField3.setText("");
            etField4.setText("");
            Toast.makeText(this, "Alumno guardado correctamente ", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            tvTitle.setText(ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void Cursos(String id_curso) {

        try{
            AdminSQLLiteOpenHelper admin = new AdminSQLLiteOpenHelper(this, DATABASE_NAME, null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues curso = new ContentValues();
            curso.put("id_curso", etField1.getText().toString());
            curso.put("curso", etField2.getText().toString());
            db.update("Cursos", curso, "id_curso = ?", new String[]{ id_curso});
            etField1.setText("");
            etField2.setText("");
            Toast.makeText(this, "Curso guardado correctamente ", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Ha ocurrido un error " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}