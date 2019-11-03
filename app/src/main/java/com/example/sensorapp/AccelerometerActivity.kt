package com.example.sensorapp

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_accelerometer.*

class AccelerometerActivity : AppCompatActivity(), SensorEventListener {

    var sensorManager: SensorManager? = null


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        textX.text = "${event!!.values[0]}"
        textY.text = "${event!!.values[1]}"
        textZ.text = "${event!!.values[2]}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager!!.registerListener(
            this,
            sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )


    }

}
