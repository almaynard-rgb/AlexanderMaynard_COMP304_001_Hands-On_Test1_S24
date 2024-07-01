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

    //OnStart override
    override fun onStart() {
        super.onStart()

        //find a reference to the checkboxes and add them the checkBoxesArray for later use
        val checkboxesArray : Array<CheckBox> = arrayOf(
            findViewById(R.id.activity_maynard_checkbox_1),
            findViewById(R.id.activity_maynard_checkbox_2),
            findViewById(R.id.activity_maynard_checkbox_3),
            findViewById(R.id.activity_maynard_checkbox_4)
        )

        //change the action bar title for this activity
        supportActionBar?.title = resources.getString(R.string.activity_maynard_actionbar_text)

        //create zig zag line like in the midterm example (pass in the y coordinates string-array from strings.xml)
        createZigZagLine(resources.getStringArray(R.array.zig_zag_image_y_coordinates))

        //get a reference to the next button
        val nextBtn = findViewById<Button>(R.id.activity_maynard_next_button)
        //create a click listener for the next button
        nextBtn.setOnClickListener {
            //when clicked reset the message
            var messageToToast  = ""
            //loop through all checkboxes to see which ones are checked
            for (checkbox in checkboxesArray) {
                //if a checkbox is checked
                if (checkbox.isChecked) {
                    //append the checkbox text to the message
                    messageToToast += "${checkbox.text}, "
                }
            }
            //toast to display all the selected checkboxes after each 'checked' checkbox text is appended properly
            //*****NOTE: some of the Toast text is cutoff as custom Toast dialogs are deprecated
            Toast.makeText(applicationContext, messageToToast, Toast.LENGTH_SHORT).show()
        }
    }

    //function to create the zig zag line line like in the midterm example
    private fun createZigZagLine(yCoordinates: Array<String>) {
        //defined amount to increment by (set by the midterm specifications).
        val xCoordinateIncrementValue = 100F

        //get a reference to the imageview
        val zigZagImage = findViewById<ImageView>(R.id.activity_maynard_image_view)
        //create a bitmap, canvas and paint objects
        val zigZagBitmap : Bitmap = Bitmap.createBitmap(800, 100, Bitmap.Config.ARGB_8888)
        val zigZagCanvas = Canvas(zigZagBitmap)
        val zigZagPaint = Paint(Paint.ANTI_ALIAS_FLAG)

        //set the color to white (like in the example)
        zigZagPaint.setColor(Color.WHITE)
        //set the width of the paint stroke
        zigZagPaint.strokeWidth = 8F
        //set the image bitmap to the zigZagBitmap
        zigZagImage.setImageBitmap(zigZagBitmap)

        //set the current (initial x coordinate to 0 like the midterm states)
        var currentXCoordinate = 0.0F

        //loop through all y values to paint our lines
        for (index in yCoordinates.indices) {
            //if we hit the second last index we should return as the lines are painted by using the current and next point,
            //therefore the last point will have an out of index error despite already being drawn without this check
            if(index == yCoordinates.size -1) {
                return
            //otherwise...
            } else {
                //... draw the lines by using the current point and the next points for x and y coordinates
                zigZagCanvas.drawLine(currentXCoordinate, yCoordinates[index].toFloat(), currentXCoordinate + xCoordinateIncrementValue, yCoordinates[index + 1].toFloat(), zigZagPaint)
                //increment our x values by 100 as stated by the midterm
                currentXCoordinate += xCoordinateIncrementValue
            }
        }
    }
}