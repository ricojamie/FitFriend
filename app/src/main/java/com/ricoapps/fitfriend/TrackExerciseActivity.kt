package com.ricoapps.fitfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutData
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutDataDatabase
import kotlinx.android.synthetic.main.activity_track_exercise.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

class TrackExerciseActivity : AppCompatActivity() {
    var myDate = Date()


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_exercise)

        val workoutDataList = ArrayList<WorkoutData>()


        val formatter = SimpleDateFormat("MMM dd yyyy HH:mma")
        val answer: String = formatter.format(myDate)
        Log.d("answer",answer)

        Log.d("Testing This", "${myDate}")


        val exerciseName = intent.getStringExtra("exercise")

        Log.d("Howdy", exerciseName)

        var weight: Double = 0.0
        var reps: Int = 0

        exerciseNameText.text = exerciseName

        weightInput.setText(weight.toString())

        saveButton.setOnClickListener {
            saveWorkout()
        }

        button.setOnClickListener {
            WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().getAllWorkoutData()
                .forEach {
                    workoutDataList.add(
                        WorkoutData(
                            it.id,
                            it.exerciseName,
                            it.repCount,
                            it.weight,
                            it.notes,
                            it.date
                        )
                    )
                }
            Log.d("hello", "")
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

    private fun saveWorkout() {
        WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().insertExercise(WorkoutData(
            null, exerciseNameText.text.toString(),
            repsInput.text.toString().toInt(),
            weightInput.text.toString().toDouble(), "", myDate))
           Log.d("Hello", "It is saved")
    }


}

