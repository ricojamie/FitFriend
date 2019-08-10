package com.ricoapps.fitfriend.WorkoutDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ricoapps.fitfriend.CurrentSet
import java.util.*


@Dao
interface WorkoutDataDao {
    @Query("SELECT * FROM workout_data WHERE exercise_name = :exerciseName AND date = :date")
    fun getWorkingSet(exerciseName: String, date: String): Array<WorkoutData>

    @Query("SELECT * FROM workout_data")
    fun getAllWorkoutData() : List<WorkoutData>

    @Query("SELECT * FROM workout_data WHERE date = :date")
    fun getTodaysWorkoutData(date: String): Array<WorkoutData>

//    @Query("SELECT weight & rep_count FROM workout_data WHERE date = :date & exercise_name = :exerciseName")
//    fun getTheSetInfo(date :Date, exerciseName: String): Array<CurrentSet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercise(workout_data: WorkoutData)

    @Delete
    fun deleteWorkoutData(workout_data: WorkoutData)

    @Query("DELETE FROM workout_data WHERE id = :id")
    fun deleteSet(id: Long?)
}