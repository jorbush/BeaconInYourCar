package com.example.beaconinyourcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoadPlace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_load_place)
    }
}