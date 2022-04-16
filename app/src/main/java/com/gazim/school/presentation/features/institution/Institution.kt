package com.gazim.school.presentation.features.institution

import com.gazim.school.domain.models.InstitutionModel


data class Institution(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val location: String,
    val favorite: Boolean = false
) {
    companion object {
        fun mapFromDomain(institutionModel: InstitutionModel) = Institution(
            id = institutionModel.id,
            image = institutionModel.image,
            title = institutionModel.title,
            description = institutionModel.description,
            location = institutionModel.location,
            favorite = institutionModel.favorite
        )
    }

    val mapToDomain
        get() = InstitutionModel(
            id = id,
            image = image,
            title = title,
            description = description,
            location = location,
            favorite = favorite
        )
}
