package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.events.ArduinoSensorEvent;
import com.example.myapplication.services.ArduinoAlarmService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;
    private TextView mResultBarTxt;
    private ProgressBar mResultBar;

    // 최초에 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 수분 값 Layout을 코드로 연결
        mResult = (TextView) findViewById(R.id.result_txt);
        mResultBarTxt = (TextView) findViewById(R.id.result_txt_bar);
        mResultBar = (ProgressBar) findViewById(R.id.result_bar);

        // 알람 서비스 실행
        startService(new Intent(this, ArduinoAlarmService.class));
    }

    // 화면이 보이기 직전에 호출
    @Override
    protected void onResume() {
        super.onResume();

        // 이벤트버스에 등록
        EventBus.getDefault().register(this);
    }

    // 화면이 꺼지기 직전에 호출
    @Override
    protected void onPause() {
        super.onPause();

        // 이벤트버스에 해제
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onArduinoSensorEvent(ArduinoSensorEvent event) {
        // 이벤트를 받을 곳
        Log.d("ArduinoAlarmService", "getMoisture: " + event.moisture);
        mResult.setText("" + event.moisture);
        if (event.moisture <= 300){
            mResultBarTxt.setText("부족");
        } else if (event.moisture > 300 && event.moisture < 700){
            mResultBarTxt.setText("적당");
        } else {
            mResultBarTxt.setText("과다");
        }
        mResultBar.setProgress(event.moisture);
    }
}