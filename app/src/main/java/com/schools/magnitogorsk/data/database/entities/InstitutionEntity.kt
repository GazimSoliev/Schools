package com.schools.magnitogorsk.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.schools.magnitogorsk.domain.models.InstitutionModel


@Entity(tableName = "institutions")
data class InstitutionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "favorite")
    val favorite: Boolean = false
) {

    val mapToDomain
        get() = InstitutionModel(
            id = id,
            image = image,
            title = title,
            description = description,
            location = location,
            favorite = favorite
        )

    companion object {
        fun mapFromDomain(institutionModel: InstitutionModel) = InstitutionEntity(
            id = institutionModel.id,
            image = institutionModel.image,
            title = institutionModel.title,
            description = institutionModel.description,
            location = institutionModel.location,
            favorite = institutionModel.favorite
        )
    }

}
