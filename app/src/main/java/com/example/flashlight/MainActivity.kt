package com.example.flashlight

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {

    var flash = false
    var flashOn= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun imgButton(view: View) {
        val imgeButton = findViewById<ImageButton>(R.id.imgButton)
        flash = packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
       if (flash){
           if (flashOn){
               flashOn = false
               imgeButton.setImageResource(R.drawable.offimage)
               flashlightoff()

           }else{
               flashOn = true
               imgeButton.setImageResource(R.drawable.onimage2)
               flashlighton()
           }

       }
    }

    private fun flashlighton()  {


        var cameramanager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        var cameraId =String
        try{


           val cameraId= cameramanager.cameraIdList[0]
            cameramanager.setTorchMode(cameraId, true)
        }catch (e:Exception){}
    }


    private fun flashlightoff() {
        var cameramanager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        var cameraId = String
        try {

           val cameraId = cameramanager.cameraIdList[0]
            cameramanager.setTorchMode(cameraId, false)
        } catch (e: Exception) { }
    }

}