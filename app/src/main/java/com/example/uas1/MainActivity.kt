package com.example.uas1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "ActivityLifecycle"
    private lateinit var tvLogStatus: TextView
    private val logBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Setup window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize TextView
        tvLogStatus = findViewById(R.id.tvLogStatus)

        logEvent("onCreate()")
    }

    override fun onStart() {
        super.onStart()
        logEvent("onStart()")
    }

    override fun onResume() {
        super.onResume()
        logEvent("onResume()")
    }

    override fun onPause() {
        super.onPause()
        logEvent("onPause()")
    }

    override fun onStop() {
        super.onStop()
        logEvent("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        logEvent("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent("onDestroy()")
    }

    private fun logEvent(event: String) {
        Log.d(TAG, event)
        logBuilder.append(event).append("\n")
        tvLogStatus.text = logBuilder.toString()
    }
}