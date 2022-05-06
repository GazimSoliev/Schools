package com.gazim.data.datasource

import com.gazim.data.database.entities.InstitutionEntity
import kotlinx.serialization.Serializable

@Serializable
data class InstitutionAssetsEntity(
    val image: String,
    val title: String,
    val description: String,
    val location: String
) {

    fun mapToInstitutionEntity() = InstitutionEntity(
        image = image,
        title = title,
        description = description,
        location = location
    )

}