package com.alexander.maynard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Student ID: 301170707
class AlexanderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexander)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //OnStart override
    override fun onStart() {
        super.onStart()
        //change the action bar title for this activity
        supportActionBar?.title = resources.getString(R.string.activity_alexander_actionbar_text)

        //get a reference to the ImageButton
        val selectExercisesImgBtn = findViewById<ImageButton>(R.id.activity_alexander_brain_challenge_image_btn)
        //create a click listener
        selectExercisesImgBtn.setOnClickListener {
            //when clicked proceed to the next activity with an intent
            val i = Intent(this@AlexanderActivity, MaynardActivity::class.java)
            startActivity(i)
        }
    }
}