package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMoistureActivity;
    private TextView mCalendarActivity;
    private TextView mIlluminationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mMoistureActivity = (TextView) findViewById(R.id.sensor_start);
        mCalendarActivity = (TextView) findViewById(R.id.calendar_start);
        mIlluminationActivity = (TextView) findViewById(R.id.illumination_start);
        mMoistureActivity.setOnClickListener(this);
        mCalendarActivity.setOnClickListener(this);
        mIlluminationActivity.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sensor_start : {
                startActivity(new Intent(this , MainActivity.class));
                break;
            }
            case R.id.calendar_start : {
                startActivity(new Intent(this , CalendarActivity.class));
                break;
            }
            case R.id.illumination_start : {
                startActivity(new Intent(this , IlluminationActivity.class));
                break;
            }
        }
    }
}
