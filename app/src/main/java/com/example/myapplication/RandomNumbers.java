package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class RandomNumbers extends AppCompatActivity {
    TextView text;
    int lowRange = 0;
    int highRange = 45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_numbers);
    }

    public void Random(View view) {
        Random r = new Random();
        int num = r.nextInt(highRange-lowRange+1) + lowRange;
        text =  findViewById(R.id.number);
        text.setText(String.valueOf(num));

    }

    public void back(View view) {
        Intent intent = new Intent(this,Inicio.class);
        startActivity(intent);
        finish();
    }

    public void exitApp(View view) {
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
}
