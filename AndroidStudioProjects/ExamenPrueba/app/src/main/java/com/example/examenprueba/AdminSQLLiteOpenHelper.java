package com.example.examenprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLLiteOpenHelper(@Nullable Context context, @Nullable String database_name, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int version)  {
        super(context, database_name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Cursos(id_curso text PRIMARY KEY," +
                "curso text)");
        db.execSQL("CREATE TABLE Alumnos(dni text PRIMARY KEY," +
                "nombre text," +
                "edad int," +
                "id_curso text," +
                "FOREIGN KEY(id_curso) REFERENCES Cursos(id_curso))");
        db.execSQL("INSERT INTO Alumnos (dni, nombre, edad, id_curso) VALUES ('22758311H', 'Pedro', 10, 'DAM3')");
        db.execSQL("INSERT INTO Cursos (id_curso, curso) VALUES ('DAM3', 'Desarrollo De Aplicaciones Multiplataforma')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //db.execSQL("ALTER TABLE ALumnos ADD fecha_nac date");
    }
}
