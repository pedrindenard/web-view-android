package com.app.random.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.app.random.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Testing
        binding.layout.settings.apply {
            javaScriptCanOpenWindowsAutomatically = true
            allowContentAccess = true
            javaScriptEnabled = true
            allowFileAccess = true
            domStorageEnabled = true
        }

        //Testing
        binding.layout.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        //Testing
        window.setFlags(
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
        )

        //This need to be loaded without file, need to be string because metadata and user info
        binding.layout.loadUrl("file:///android_asset/index.html")
    }
}