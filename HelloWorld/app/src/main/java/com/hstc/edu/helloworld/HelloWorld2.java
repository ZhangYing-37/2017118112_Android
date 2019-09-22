package com.hstc.edu.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HelloWorld2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello2_layout);
        Button hello1 = (Button) findViewById(R.id.Hello1);
        Button hello2 = (Button) findViewById(R.id.Hello2);
        hello2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorld2.this, HelloWorld2.class);
                startActivity(intent);
            }
        });
        hello1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorld2.this, HelloWorld1.class);
                startActivity(intent);
            }
        });
    }
}
