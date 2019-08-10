package com.ricoapps.fitfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutData
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutDataDatabase
import kotlinx.android.synthetic.main.activity_exercise_list.*
import kotlinx.android.synthetic.main.activity_track_exercise.*
import kotlinx.android.synthetic.main.track_exercise_list.*
import java.text.SimpleDateFormat
import java.util.*

class TrackExerciseActivity : AppCompatActivity() {
    var myDate = Date()
    var theDate :String = ""
    var weight: Double = 0.0
    var reps: Int = 0

    val workoutDataList = ArrayList<WorkoutData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_exercise)

        weight = 0.0

        val formatter = SimpleDateFormat("MMM dd yyyy")
        theDate = formatter.format(myDate)
        Log.d("answer", theDate)

        Log.d("Testing This", "${myDate}")

        val exerciseName = intent.getStringExtra("exercise")

        Log.d("Howdy", exerciseName)

        exerciseNameText.text = exerciseName

        weightInput.setText(weight.toString())

        saveButton.setOnClickListener {
            saveWorkout()
            workoutDataList.clear()
            Log.d("Testing","It cleared")
            getWorkingSet(exerciseName)
            Log.d("Testing", "It reloaded")
            exerciseTrackInfo.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
            exerciseTrackInfo.adapter = TrackExerciseAdapter(workoutDataList, this)
        }

        WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().getWorkingSet(exerciseName, theDate)
            .forEach{
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

        exerciseTrackInfo.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        exerciseTrackInfo.adapter = TrackExerciseAdapter(workoutDataList, this)

        minusButton.setOnClickListener {
            if (reps > 0) {
                reps = repsInput.text.toString().toInt()
                reps -= 1
            }

            repsInput.setText(reps.toString())
        }

        plusButton.setOnClickListener {
            reps = repsInput.text.toString().toInt()
            reps += 1
            repsInput.setText(reps.toString())
        }

        addCookie.setOnClickListener {
            addWeight(2.5)
        }

        addDonut.setOnClickListener {
          addWeight(5.0)
        }

        addTen.setOnClickListener {
            addWeight(10.0)
        }

        addTwentyFive.setOnClickListener {
            addWeight(25.0)
        }

        addFourtyFive.setOnClickListener {
          addWeight(45.0)
        }

    }
    
    private fun addWeight(amount: Double) {
        if(!weightInput.text.toString().isNullOrEmpty() || !weightInput.text.toString().isNullOrBlank()){
            weight = weightInput.text.toString().toDouble()
            weight += amount
            weightInput.setText(weight.toString())
        } else {
            weight = amount
            weightInput.setText(weight.toString())
            Log.d("Testing stuff", "its blank yo")
        }
    }

    private fun getWorkingSet(exerciseName :String) {

        WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().getWorkingSet(exerciseName, theDate)
            .forEach{
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
                Log.d("Hello","The save ${it.date}")
            }
        Log.d("Hello", "We added it")
        Log.d("hello", "Here it is ${theDate}")
    }

    private fun saveWorkout() {
        WorkoutDataDatabase.getInstance(applicationContext).workoutDataDao().insertExercise(
            WorkoutData(
                null, exerciseNameText.text.toString(),
                repsInput.text.toString().toInt(),
                weightInput.text.toString().toDouble(), "", theDate
            )
        )
        Log.d("Hello", "It is saved ${theDate}")
    }
}