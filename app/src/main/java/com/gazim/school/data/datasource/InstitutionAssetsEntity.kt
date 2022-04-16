package com.gazim.school.data.datasource

import kotlinx.serialization.Serializable

@Serializable
data class InstitutionAssetsEntity(
    val image: String,
    val title: String,
    val description: String,
    val location: String
)