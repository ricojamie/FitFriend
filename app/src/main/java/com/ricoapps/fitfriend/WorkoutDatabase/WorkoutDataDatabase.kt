package com.ricoapps.fitfriend.WorkoutDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(WorkoutData::class), version = 1)
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