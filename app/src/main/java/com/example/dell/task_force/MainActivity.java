package com.example.dell.task_force;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button b= findViewById(R.id.button);


        String fontPath = "fonts/Planet Kosmos.ttf";
        TextView txtGhost = findViewById(R.id.T1);
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtGhost.setTypeface(tf);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o();
            }
        });
    }

    public void o(){
        Intent intent= new Intent(this,get.class);
        startActivity(intent);
    }

}

