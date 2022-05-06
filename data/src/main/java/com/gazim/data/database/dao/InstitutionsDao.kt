package com.gazim.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gazim.data.database.entities.InstitutionEntity


@Dao
interface InstitutionsDao {

    @Insert
    fun insert(institutionEntity: InstitutionEntity)

    @Insert
    fun insertAll(institutions: List<InstitutionEntity>)

    @Query("select * from institutions")
    fun getAll(): List<InstitutionEntity>

    @Update
    fun update(institutionEntity: InstitutionEntity)

}