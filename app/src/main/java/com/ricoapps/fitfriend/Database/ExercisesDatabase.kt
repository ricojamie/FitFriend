package com.ricoapps.fitfriend.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ExerciseInfo::class), version = 3)
abstract class ExercisesDatabase: RoomDatabase() {
    abstract fun exerciseInfoDao(): ExerciseInfoDao

    companion object {
        @Volatile private var INSTANCE: ExercisesDatabase? = null

        fun getInstance(context: Context): ExercisesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it}
            }

        private fun buildDatabase(context: Context) =
           Room.databaseBuilder(context.applicationContext,
                ExercisesDatabase::class.java, "Exercises.db")
               .allowMainThreadQueries()
               .fallbackToDestructiveMigration()
               .build()
    }
}





//@Database(entities = arrayOf(User::class), version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//}