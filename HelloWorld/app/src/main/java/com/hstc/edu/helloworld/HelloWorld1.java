package com.hstc.edu.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorld1 extends AppCompatActivity {

    private static int num=0;
    private int num1;
    public static String TAG = "HelloWorld1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        num++;
        num1=num;
        Log.d(TAG+"_"+num1,"onCreate");
        setContentView(R.layout.hello1_layout);
        Button hello1 = (Button) findViewById(R.id.Hello1);
        Button hello2 = (Button) findViewById(R.id.Hello2);
        Button tip = (Button) findViewById(R.id.Tip);
        Button startDialogActivity = (Button) findViewById(R.id.dialog);
        hello1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HelloWorld1.this, HelloWorld1.class);
                startActivity(intent);
            }
        });
        hello2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorld1.this, HelloWorld2.class);
                startActivity(intent);
            }
        });
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelloWorld1.this, "Hello World1", Toast.LENGTH_SHORT).show();
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloWorld1.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG+"_"+num1,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG+"_"+num1,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG+"_"+num1,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG+"_"+num1,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG+"_"+num1,"onDestroy");
        num--;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG+"_"+num1,"onRestart");
    }
    }
