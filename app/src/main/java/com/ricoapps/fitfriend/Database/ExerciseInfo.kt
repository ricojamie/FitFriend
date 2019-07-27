package com.ricoapps.fitfriend.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_info")

data class ExerciseInfo (
    @PrimaryKey
    @ColumnInfo(name = "exercise_name") var exerciseName: String,
    @ColumnInfo(name = "body_part") var bodyPart: String,
    @ColumnInfo(name = "equipment") var equipment: String

)