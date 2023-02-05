package com.application.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
    }
    public void onstart(View view)
    {
        run=true;
    }
    public void onstop(View view)
    {
        run=false;
    }
    public void onreset(View view)
    {
        run=false;
        seconds=0;
    }
    private void startTimer()
    {
        final  TextView timer=findViewById(R.id.timer );
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int mins=(seconds%3600)/60;
                int sec=seconds%60;
                String time=String.format("%02d %02d %02d",hours,mins,sec);
                timer.setText(time);
                if(run)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}