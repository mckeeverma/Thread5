package com.example.marc.thread5;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public String TAG = "marclog";
    Thread thread1, thread2, thread3;
    int threadCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate starting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate last line");
    }
    public void button1Click(View view) {
        Log.d(TAG, "buttonClick starting");
        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        myTextView.setText("Button1 Pressed");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "runnable run method starting");
                for (int iii = 0; iii < 10; iii++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "iii = " + Integer.toString(iii));
                }
            }
        };
        Log.d(TAG, "button1Click create new thread starting");
        Thread mythread = new Thread(runnable);
        Log.d(TAG, "button1Click create new thread finished, will now start the new thread");
        ++threadCount;
        if (threadCount == 1) {
            thread1 = mythread;
        }
        if (threadCount == 2) {
            thread2 = mythread;
        }
        if (threadCount == 3) {
            thread3 = mythread;
        }
        mythread.start();
        Log.d(TAG, "button1Click right after mythread.start call");
    }
    public void button2Click(View view) {
        Log.d(TAG, "button2Click starting");
        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        try {
            Log.d(TAG, "thread1 alive? " + thread1.isAlive());
        } catch (Exception e) {
            Log.d(TAG, "thread1 exception: " + e.getMessage());
        }
        try {
            Log.d(TAG, "thread2 alive? " + thread2.isAlive());
        } catch (Exception e) {
            Log.d(TAG, "thread2 exception: " + e.getMessage());
        }
        try {
            Log.d(TAG, "thread3 alive? " + thread3.isAlive());
        } catch (Exception e) {
            Log.d(TAG, "thread3 exception: " + e.getMessage());
        }
    }
}
