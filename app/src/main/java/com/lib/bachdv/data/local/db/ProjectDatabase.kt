package com.lib.bachdv.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lib.bachdv.data.local.entity.SearchEntity
import com.lib.bachdv.data.local.db.dao.SearchDao

@Database(entities = [SearchEntity::class], version = 1, exportSchema = false)
abstract class ProjectDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProjectDatabase::class.java,
                "ProjectDatabase.db"
            ).build()
    }

}