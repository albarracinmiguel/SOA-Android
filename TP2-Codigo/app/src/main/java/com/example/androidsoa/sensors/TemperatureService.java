package com.example.androidsoa.sensors;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Build;
import android.util.Log;

public class TemperatureService  extends Service implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mTemperature;
    private float previousTemp;

    private static final float TEMPERATURE_THRESHOLD = 20F;

    private static OnTemperatureListener mListener;

    public void setOnTemperatureListener(OnTemperatureListener listener) {
        this.mListener = listener;
    }

    public interface OnTemperatureListener {
        public void onTemperatureChanges(boolean isHot);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float ambient_temperature = event.values[0];
        if(ambient_temperature != previousTemp){
            previousTemp = ambient_temperature;
            if(ambient_temperature > TEMPERATURE_THRESHOLD)
                mListener.onTemperatureChanges(true);
            if(ambient_temperature < TEMPERATURE_THRESHOLD)
                mListener.onTemperatureChanges(false);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            Log.e("ERRORFATAL", "build malo");
        }
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mTemperature = mSensorManager
                .getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, mTemperature,
                SensorManager.SENSOR_DELAY_UI, new Handler());
        return START_STICKY;
    }

}
