package com.example.beaconinyourcar

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    var thumBnail: Bitmap ?= null

    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        var btn_save:ImageView = findViewById<ImageView>(R.id.btn_save)
        btn_save.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
            {
                openCamera()
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_REQUEST_CODE){
            if(grantResults.isNotEmpty()&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera()
            }else{
                Toast.makeText(this, "The aplication needs camera permission.",
                    Toast.LENGTH_LONG)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode== CAMERA_REQUEST_CODE){
                thumBnail = data!!.extras!!.get("data") as Bitmap
                // TODO: Save the image in a file
                //var imageView: ImageView ?= null
                // imageView!!.setImageBitmap(thumBnail)
                // saveImage(thumBnail!!)
                Toast.makeText(this, "The picture was saved.", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveImage(bmp: Bitmap) {
        val file_path = Environment.getExternalStorageDirectory().absolutePath +
                "/CarImage"
        val dir = File(file_path)
        if (!dir.exists()) dir.mkdirs()
        val file = File(dir, "car" + ".png")
        val fOut = FileOutputStream(file)

        bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut)
        fOut.flush()
        fOut.close()
    }

    fun open_save_place(view: View) {
        var intent = Intent(this, SavePlace::class.java)
        startActivity(intent)
    }
    fun open_load_place(view: View) {
        var intent = Intent(this, LoadPlace::class.java)
        startActivity(intent)
    }
    fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }
}