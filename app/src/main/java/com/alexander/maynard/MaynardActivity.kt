package com.alexander.maynard

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Student ID: 301170707
class MaynardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maynard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        val checkboxesArray : Array<CheckBox> = arrayOf(
            findViewById(R.id.activity_maynard_checkbox_1),
            findViewById(R.id.activity_maynard_checkbox_2),
            findViewById(R.id.activity_maynard_checkbox_3),
            findViewById(R.id.activity_maynard_checkbox_4)
        )

        val nextBtn = findViewById<Button>(R.id.activity_maynard_next_button)
        nextBtn.setOnClickListener {
            var messageToToast : String = ""
            for (checkbox in checkboxesArray) {
                if (checkbox.isChecked) {
                    messageToToast += "${checkbox.text}\n"
                }
            }
            val t = Toast.makeText(applicationContext, messageToToast, Toast.LENGTH_SHORT)
            t.setGravity(Gravity.FILL, 40, 40)
            t.show()
        }
    }
}