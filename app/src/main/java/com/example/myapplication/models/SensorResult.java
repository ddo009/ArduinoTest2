package com.example.myapplication.models;

/**
 * 아두이노에서 얻어오는 센서값
 */
public class SensorResult {
    private int moisture;
    private int illumination;

    public int getIllumination() {
        return illumination;
    }

    public void setIllumination(int illumination) {
        this.illumination = illumination;
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }
}
