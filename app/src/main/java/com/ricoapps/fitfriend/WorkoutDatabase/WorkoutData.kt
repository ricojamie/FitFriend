package com.ricoapps.fitfriend.WorkoutDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "workout_data")

data class WorkoutData (
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo(name = "exercise_name") var exerciseName: String,
    @ColumnInfo(name = "rep_count") var repCount: Int,
    @ColumnInfo(name = "weight") var weight: Double,
    @ColumnInfo(name = "notes") var notes: String,
    @ColumnInfo(name = "date") var date: Date?
)