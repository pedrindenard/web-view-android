package com.app.random.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.random.databinding.ActivityMainBinding
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handlerWebView()
    }

    @SuppressLint(value = ["SetJavaScriptEnabled"])
    private fun handlerWebView() {
        binding.layout.settings.javaScriptEnabled = true
        binding.layout.settings.domStorageEnabled = true
        binding.layout.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        binding.layout.loadDataWithBaseURL("https://binds.co",
            this.getHtmlPage(
                name = "Dev Android",
                email = "dev.compass@gmail.com",
                phone = "958375967",
                data = ""
            ),
            "text/html",
            "UTF-8",
            null
        )
    }

    private fun getHtmlPage(name: String, email: String, phone: String, data: String) : String {
        val `is`: InputStream = this.assets.open("index.html")
        val size: Int = `is`.available()

        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()

        var str = String(buffer)
        str = str.replace(oldValue = "%name%", newValue = name)
        str = str.replace(oldValue = "%email%", newValue = email)
        str = str.replace(oldValue = "%phone%", newValue = phone)
        str = str.replace(oldValue = "%data%", newValue = data)

        return str
    }
}