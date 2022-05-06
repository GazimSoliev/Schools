package com.gazim.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gazim.data.database.dao.InstitutionsDao
import com.gazim.data.database.entities.InstitutionEntity


@Database(
    entities = [InstitutionEntity::class],
    exportSchema = true,
    version = 1
)
abstract class InstitutionsDatabase : RoomDatabase() {

    abstract fun institutionsDao(): InstitutionsDao

    companion object {
        const val DATABASE = "DatabaseInstitutions"
    }

}