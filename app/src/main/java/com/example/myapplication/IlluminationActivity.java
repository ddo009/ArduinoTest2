package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.events.ArduinoSensorEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class IlluminationActivity extends AppCompatActivity {

    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illumination);

        mResult = (TextView) findViewById(R.id.result_txt);
    }

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
        Log.d("ArduinoAlarmService", "getIllumination: " + event.illumination);
        mResult.setText("" + event.illumination);
    }

}
