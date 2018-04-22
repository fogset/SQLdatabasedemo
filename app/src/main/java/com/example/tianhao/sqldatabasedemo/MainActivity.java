package com.example.tianhao.sqldatabasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDataBase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
        //myDataBase.execSQL("INSERT INTO users (name, age) VALUES ('Nick ', 28)");
        //myDataBase.execSQL("INSERT INTO users (name, age) VALUES ('sarah ', 24)");

        Cursor c = myDataBase.rawQuery("SELECT * FROM users", null);
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");
        c.moveToFirst();
        while (c !=null){
            Log.i("name", c.getString(nameIndex));
            Log.i("age", c.getString(ageIndex));
            c.moveToNext();
        }
    }
}
