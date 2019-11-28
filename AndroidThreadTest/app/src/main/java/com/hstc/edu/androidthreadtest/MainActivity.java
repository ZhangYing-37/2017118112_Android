package com.hstc.edu.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int UPDATE_TEXT = 1;
    private TextView text;

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    // 在这里可以进行UI操作
                    Pa tmp;
                    tmp = ((Pa)msg.obj);
                    text.setText("我是："+tmp.getTid()+"\n我的值:"+tmp.getCounter());
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button changeText = (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_text:
                DemoThread thread1 = new DemoThread();
                Log.d("子线程号",""+thread1.getId());
                try {
                    //Thread.sleep(1000);
                    thread1.start();
                }catch (Exception e){

                }
               Log.d("主线程号",""+Thread.currentThread().getId());
                break;
            default:
                break;
        }
    }

    class DemoThread extends Thread{
        private int counter=0;
        @Override
        public void run(){
            while(true){
                counter++;
                Message message = new Message();
                message.what = UPDATE_TEXT;
                message.obj= new Pa(Thread.currentThread().getId(),counter);
                handler.sendMessage(message);

            try{
                Thread.sleep(1000);
            }catch (Exception e){
                break;
            }
            }
        }
    }
    class Pa{
        private long tid;
        private int counter;
        public Pa(long tid,int counter){
            this.tid=tid;
            this.counter=counter;
        }
        public int getCounter(){
            return counter;
        }
        public long getTid(){
            return tid;
        }
    }
}
