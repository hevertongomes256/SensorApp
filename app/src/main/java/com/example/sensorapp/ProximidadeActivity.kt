package com.example.sensorapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_proximidade.*
import java.io.IOException

class ProximidadeActivity : AppCompatActivity(), SensorEventListener {

    var sensor : Sensor? = null
    var sensorManager : SensorManager? = null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    var isRunning = false

    override fun onSensorChanged(event: SensorEvent?) {

        try {
            if (event!!.values[0] < 80 && isRunning == false){
                isRunning = true
                gifImg.visibility = View.VISIBLE
            } else{
                isRunning = false
                gifImg.visibility = View.INVISIBLE
            }

        } catch (e : IOException){

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximidade)

        gifImg.visibility = View.INVISIBLE

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)


    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}
