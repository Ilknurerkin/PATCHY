package com.erkin.p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView oyn;
    TextView acklma;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oyn=(TextView)findViewById(R.id.oyunadı);
        acklma=(TextView)findViewById(R.id.acıklama);
        btn=(Button)findViewById(R.id.oyunabasla);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Oyun.class);
                startActivity(i);
                finish();


            }
        });
    }}

