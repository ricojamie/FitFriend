package com.ricoapps.fitfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutData
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutDataDatabase
import kotlinx.android.synthetic.main.activity_track_exercise.*
import java.sql.Date
import java.text.DateFormat
import java.util.*

class TrackExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_exercise)

        Calendar.getInstance()
        val date = DateFormat.getDateInstance(DateFormat.FULL)

        Log.d("Testing This", "${date}")




        val exerciseName = intent.getStringExtra("exercise")

        Log.d("Howdy", exerciseName)

        var weight: Double = 0.0
        var reps: Int = 0

        exerciseNameText.text = exerciseName

        weightInput.setText(weight.toString())

        saveButton.setOnClickListener {
//            saveWorkout()
        }

        minusButton.setOnClickListener {
            reps -= 1
            repsInput.setText(reps.toString())
        }

        plusButton.setOnClickListener {
            reps += 1
            repsInput.setText(reps.toString())
        }

        addCookie.setOnClickListener {
            weight += 2.5
            weightInput.setText(weight.toString())
        }

        addDonut.setOnClickListener {
            weight += 5.0
            weightInput.setText(weight.toString())
        }

        addTen.setOnClickListener {
            weight += 10
            weightInput.setText(weight.toString())
        }

        addTwentyFive.setOnClickListener {
            weight += 25
            weightInput.setText(weight.toString())
        }

        addFourtyFive.setOnClickListener {
            weight += 45
            weightInput.setText(weight.toString())
        }
    }

//    private fun saveWorkout() {
//        WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().insertExercise(WorkoutData(
//            null, exerciseNameText.text.toString(),
//            repsInput.toString().toInt(),
//            weightInput.toString().toDouble(), "", Date.valueOf()))
//    }



}

