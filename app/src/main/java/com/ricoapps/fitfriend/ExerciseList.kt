package com.ricoapps.fitfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricoapps.fitfriend.Database.ExerciseInfo
import com.ricoapps.fitfriend.Database.ExercisesDatabase
import kotlinx.android.synthetic.main.activity_exercise_list.*

class ExerciseList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    val exerciseInfoList = ArrayList<ExerciseInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)


        exerciseInfoList.clear()

//        ExercisesDatabase.getInstance(applicationContext).exerciseInfoDao().insertExercise(ExerciseInfo("Bench Press", "Chest", "Barbell"))

        ExercisesDatabase.getInstance(applicationContext).exerciseInfoDao().getAllExercises()
            .forEach {
                exerciseInfoList.add(
                    ExerciseInfo(
                        it.exerciseName,
                        it.bodyPart,
                        it.equipment
                    )
                )
            }

        exercisesRecyclerView.layoutManager = LinearLayoutManager(this)
        exercisesRecyclerView.adapter = ExerciseListAdapter(exerciseInfoList, this)


        chestChip.setOnCheckedChangeListener { compoundButton, b ->
            chestChip.isChecked
            if (chestChip.isChecked) {
                getExercisesByBodyPart("Chest")
                Log.d("Jamie", "Hello it is checked ${chestChip.isChecked}")
            } else
                exerciseInfoList.clear()
            Log.d("Jamie", "Hello is not checked ${chestChip.isChecked}")
        }

    }

    private fun getExercisesByBodyPart(bodyPart: String) {
        exerciseInfoList.clear()
        ExercisesDatabase.getInstance(applicationContext).exerciseInfoDao().getExercisesByBodyPart(bodyPart)
            .forEach {
                exerciseInfoList.add(
                    ExerciseInfo(
                        it.exerciseName,
                        it.bodyPart,
                        it.equipment
                    )
                )
            }

    }
}


