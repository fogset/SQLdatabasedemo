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
        try {
                SQLiteDatabase myDataBase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
                myDataBase.execSQL("CREATE TABLE IF NOT EXISTS newList (name VARCHAR, age INT(3),id INTEGER PRIMARY KEY)");
                //myDataBase.execSQL("INSERT INTO newList (name, age) VALUES ('Nick ', 48)");
                //myDataBase.execSQL("INSERT INTO newList (name, age) VALUES ('sarah ', 24)");
                //myDataBase.execSQL("INSERT INTO newList (name, age) VALUES ('hello ', 29)");
                myDataBase.execSQL("DELETE FROM newLIst WHERE id  =2");

                Cursor c = myDataBase.rawQuery("SELECT * FROM newList", null);
                int nameIndex = c.getColumnIndex("name");
                int ageIndex = c.getColumnIndex("age");
                int idIndex = c.getColumnIndex("id");
                c.moveToFirst();
                while (c != null) {
                    Log.i("name", c.getString(nameIndex));
                    Log.i("age", c.getString(ageIndex));
                    Log.i("id", c.getString(idIndex));

                    c.moveToNext();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

    }
}
