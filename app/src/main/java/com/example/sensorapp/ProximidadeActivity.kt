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

    private lateinit
    var sensorManager: SensorManager
    private var mProximity: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximidade)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


    override fun onSensorChanged(event: SensorEvent) {
        val distance = event.values[0]
        textProximidade.text = distance.toString()

        if(distance >= 8){
            ivMicrofone.setImageResource(R.drawable.fone2)
        }else{
            ivMicrofone.setImageResource(R.drawable.fone)

        }

    }

    override fun onResume() {
        super.onResume()

        mProximity?.also { proximity ->
            sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()

        sensorManager.unregisterListener(this)

    }


}
