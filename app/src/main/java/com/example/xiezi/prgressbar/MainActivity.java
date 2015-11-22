package com.example.xiezi.prgressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int i=0;
    private int m=1;
    private CircleProgress circleProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgress=(CircleProgress)findViewById(R.id.view);

        circleProgress.setAngel(270);






    }



}
