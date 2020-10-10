package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Intent intent = getIntent();
        int activityNumber = intent.getIntExtra("activity", 0);
        if (activityNumber == 1 ){
            this.finish();
        }



    }


    public void Chronometer(View view) {
        Intent intent = new Intent(this,Chronometer.class);
        startActivity(intent);
        finish();

    }

    public void Exit(View view) {
        onBackPressed();

    }

    public void onBackPressed(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setTitle("Exit");
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


    public void Random(View view) {
        Intent intent = new Intent(this,RandomNumbers.class);
        startActivity(intent);
        finish();

    }


    public void notePad(View view) {
        Intent intent = new Intent(this,notePad.class);
        startActivity(intent);

    }

    public void calendario (View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
        finish();
    }
}
