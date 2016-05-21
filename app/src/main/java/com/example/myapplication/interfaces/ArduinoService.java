package com.example.myapplication.interfaces;

import com.example.myapplication.models.SensorResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 이정아 on 2016-05-07.
 */
public interface ArduinoService {
    // 서버의 RootUrl
    // TODO 테더링시 IP값 받아서 변경하세요~!!!!
    String BASE_URL = "http://192.168.0.29";

    @GET("/")
    Call<SensorResult> getSensorResult();
}
