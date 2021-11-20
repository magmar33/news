package com.example.news.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object{
        @Volatile
        private var instance : MyDatabase? = null
        private val LOCK = Any() //Cualquiera

        operator  fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance ?: buildDatabase(context)
                    .also {
                        instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MyDatabase::class.java,"mydatabase.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}