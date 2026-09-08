package com.example.multiscreenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FourthActivity : AppCompatActivity() {

    private val observer = MyLifecycleObserver(this::class.java.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycle.addObserver(observer)

        findViewById<Button>(R.id.next).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                //or we can use Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(it)
            }
        }

        findViewById<Button>(R.id.previous).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}