package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

public class Chronometer extends AppCompatActivity {

    private android.widget.Chronometer chron;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);

        chron = findViewById(R.id.chron);




    }


    public void start(View view) {
        if (!running){
            chron.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chron.start();
            running = true;
        }


    }

    public void stop(View view) {
        if(running){
            chron.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chron.getBase();
            running = false;
        }
    }

    public void reset(View view) {
        chron.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
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

    public void back(View view) {
        Intent intent = new Intent(this,Inicio.class);
        startActivity(intent);
        finish();

    }
}
