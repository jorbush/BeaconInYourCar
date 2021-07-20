package com.example.beaconinyourcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    fun open_save_place(view: View) {
        var intent = Intent(this, SavePlace::class.java)
        startActivity(intent)
    }
    fun open_load_place(view: View) {
        var intent = Intent(this, LoadPlace::class.java)
        startActivity(intent)
    }
}