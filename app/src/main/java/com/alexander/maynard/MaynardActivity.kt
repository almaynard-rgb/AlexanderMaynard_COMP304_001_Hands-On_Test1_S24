package com.alexander.maynard

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

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
            var messageToToast  = ""
            for (checkbox in checkboxesArray) {
                if (checkbox.isChecked) {
                    messageToToast += "${checkbox.text} "
                }
            }

            //toast to display all the text
            Toast.makeText(applicationContext, messageToToast, Toast.LENGTH_SHORT).show()

            //Snackbar to prove everything is there in the Toast as some of the text is cutoff and custom Toasts are deprecated.
            Snackbar.make(it, messageToToast, Snackbar.LENGTH_LONG).show()
        }
    }
}