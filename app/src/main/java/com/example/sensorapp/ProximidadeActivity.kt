package com.example.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_proximidade.*
import java.io.IOException

class ProximidadeActivity : AppCompatActivity(), SensorEventListener {

    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


    override fun onSensorChanged(event: SensorEvent?) {


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximidade)
        

    }

}
