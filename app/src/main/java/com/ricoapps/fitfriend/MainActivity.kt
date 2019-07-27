package com.ricoapps.fitfriend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startWorkout.setOnClickListener {
            val intent = Intent(this, ExerciseList::class.java)
            startActivity(intent)
        }

    }

}
