package com.schools.magnitogorsk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.schools.magnitogorsk.data.database.dao.InstitutionsDao
import com.schools.magnitogorsk.data.database.entities.InstitutionEntity


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