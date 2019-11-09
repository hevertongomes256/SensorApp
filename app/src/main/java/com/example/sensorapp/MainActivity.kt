package com.example.sensorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSensorProximidade.setOnClickListener {
            startActivity(Intent(this, ProximidadeActivity::class.java))
        }
        buttonSensorLight.setOnClickListener {
            startActivity(Intent(this, SensorLightActivity::class.java))
        }

        buttonSensorAccelerometer.setOnClickListener {
            startActivity(Intent(this, AccelerometerActivity::class.java))
        }

        buttonSensorGiroscopio.setOnClickListener {
            startActivity(Intent(this, GiroscopioActivity::class.java))
        }
    }
}
