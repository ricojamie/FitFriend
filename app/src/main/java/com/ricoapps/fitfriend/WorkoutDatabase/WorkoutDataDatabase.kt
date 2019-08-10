package com.ricoapps.fitfriend.WorkoutDatabase

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(WorkoutData::class), version = 2)
@TypeConverters(Converters::class)
abstract class WorkoutDataDatabase: RoomDatabase() {
    abstract fun workoutDataDao(): WorkoutDataDao

    companion object {
        @Volatile private var INSTANCE: WorkoutDataDatabase? = null

        fun getInstance(context: Context): WorkoutDataDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?:buidDataBase(context).also{INSTANCE = it}
            }

        private fun buidDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                WorkoutDataDatabase::class.java, "WorkoutData.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}