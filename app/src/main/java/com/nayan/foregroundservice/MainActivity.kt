package com.nayan.foregroundservice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.nayan.foregroundservice.service.ForgroundService

class MainActivity : AppCompatActivity() {

    private var editTextInput: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextInput = findViewById(R.id.edit_text_input)
    }

    fun startService(view: View) {
        var input = editTextInput?.text.toString()

        val intent = Intent(this, ForgroundService::class.java)
        intent.putExtra("input", input)

        ContextCompat.startForegroundService(this, intent)

        //use for long running background task
        // startService(intent)
    }

    fun stopService(view: View) {

        val intent = Intent(this, ForgroundService::class.java)
        stopService(intent)
    }
}