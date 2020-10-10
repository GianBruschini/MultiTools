package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class notePad extends AppCompatActivity {
    TextView text;
    String t;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_pad);


        SharedPreferences preferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        text = (EditText) findViewById(R.id.EditText1);
        t = preferences.getString("editText",null);
        text = (EditText) findViewById(R.id.EditText1);
        text.setText(t);




    }


    public void save(View view) {
        onBackPressed2();

    }

    private void onBackPressed2() {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do you want to save?");
        builder.setTitle("Save current note");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveOnShared();
            }


        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    public void saveOnShared(){
        SharedPreferences sharedPref = getSharedPreferences("PREFS",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        text = (EditText) findViewById(R.id.EditText1);
        String texto = text.getText().toString();

        editor.putString("editText",texto);
        editor.commit();

    }


    public void deleteAll(View view) {

        onBackPressed3();

    }

    private void onBackPressed3() {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do you want to delete your text?");
        builder.setTitle("Delete text");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                delete();
            }


        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    private void delete() {
        text = (EditText) findViewById(R.id.EditText1);
        text.setText("");
        SharedPreferences sharedPref = getSharedPreferences("PREFS",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit().clear();
        editor.commit();

    }

    public void back(View view) {
        onBackPressed4();
    }

    private void onBackPressed4() {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do you want to go back?");
        builder.setTitle("Go back");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }


        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}
