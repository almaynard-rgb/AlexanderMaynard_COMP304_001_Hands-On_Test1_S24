package com.alexander.maynard

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
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


        //create zig zag line
        createZigZagLine(resources.getStringArray(R.array.zig_zag_image_y_coordinates))

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

    private fun createZigZagLine(yCoordinates: Array<String>) {
        //for the imageview
        val zigZagImage = findViewById<ImageView>(R.id.activity_maynard_image_view)
        val bitmap : Bitmap = Bitmap.createBitmap(800, 100, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.setColor(Color.WHITE)
        paint.strokeWidth = 8F
        zigZagImage.setImageBitmap(bitmap)
        var currentXCoordinate = 0.0F

        for (index in yCoordinates.indices) {
            if(index == yCoordinates.size -1) {
                return
            } else {
                canvas.drawLine(currentXCoordinate, yCoordinates[index].toFloat(), currentXCoordinate + 100F, yCoordinates[index + 1].toFloat(), paint)
                currentXCoordinate += 100F
            }
        }
    }
}