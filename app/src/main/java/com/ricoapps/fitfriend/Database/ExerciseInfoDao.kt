package com.ricoapps.fitfriend.Database

import androidx.room.*
import com.ricoapps.fitfriend.Database.ExerciseInfo
import io.reactivex.Flowable

@Dao
interface ExerciseInfoDao {
    @Query("SELECT * FROM exercise_info")
    fun getAllExercises() : List<ExerciseInfo>

    @Query("SELECT * FROM exercise_info WHERE body_part = :bodyPart")
    fun getExercisesByBodyPart(bodyPart: String): Array<ExerciseInfo>

    @Query("SELECT * FROM exercise_info WHERE equipment = :equipmentSelected")
    fun getExercisesByEquipment(equipmentSelected: String): Array<ExerciseInfo>

    @Query("SELECT * FROM exercise_info WHERE body_part = :bodyPart & equipment = :equipmentSelected")
    fun getExercisesByBodyPartAndEquipment(bodyPart: String, equipmentSelected: String): Array<ExerciseInfo>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertExercise(exercise_info: ExerciseInfo)

    @Delete
    fun deleteExercise(exercise_info: ExerciseInfo)

}