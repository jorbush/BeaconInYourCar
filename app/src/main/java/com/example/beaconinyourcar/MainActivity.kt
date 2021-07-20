package com.example.beaconinyourcar

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity() {
    val RESP_TOMAR_FOTO = 1000
    var mImageView = null
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