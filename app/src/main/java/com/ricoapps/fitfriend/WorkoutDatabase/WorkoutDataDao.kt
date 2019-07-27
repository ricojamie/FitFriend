package com.ricoapps.fitfriend.WorkoutDatabase

import androidx.room.*
import java.sql.Date


@Dao
interface WorkoutDataDao {
    @Query("SELECT * FROM workout_data WHERE date = :date & exercise_name = :exerciseName")
    fun getWorkingSet(date: Date,exerciseName: String ): List<WorkoutData>

    @Query("SELECT * FROM workout_data")
    fun getAllWorkoutData() : List<WorkoutData>

    @Query("SELECT * FROM workout_data WHERE date = :date")
    fun getTodaysWorkoutData(date: Date)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercise(workout_data: WorkoutData)

    @Delete
    fun deleteWorkoutData(workout_data: WorkoutData)
}