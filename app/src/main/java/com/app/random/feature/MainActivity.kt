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
            getHtmlString(
                name = "String",
                email = "dev.compass@gmail.com",
                phone = "958375967",
                data = ""
            ),
//            this.getHtmlPage(
//                name = "index.html",
//                email = "dev.compass@gmail.com",
//                phone = "958375967",
//                data = ""
//            ),
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

    private fun getHtmlString(name: String, email: String, phone: String, data: String): String {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "<div>" +
                "<link href=\"https://widget.binds.co/css/app.css\" rel=stylesheet>" +
                "<div>" +
                "<vue-widget widget_position=\"lowerRight\"" +
                "widget_title=\"feedback\"" +
                "buttons=\"#f5f5f5\"" +
                "width=\"400\"" +
                "text_buttons=\"#35363a\"" +
                "background=\"#35363a\"" +
                "texts=\"#ffffff\"" +
                "timeout=\"0\"" +
                "width_metric=\"px\"" +
                "survey_id=\"6266ea891abd3b27d7e23db1\"" +
                "from='{\"name\": \"$name\", \"email\": \"$email\", \"phone\":\"$phone\"}'" +
                "is_to_post=\"true\"" +
                "metadata='{$data}'></vue-widget>" +
                "</div>" +
                "<script type=\"text/javascript\" src=\"https://widget.binds.co/js/app.js\"></script>" +
                "</div>" +
                "</body>" +
                "</html>"
    }
}