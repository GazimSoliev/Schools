package com.gazim.school.domain.models


data class InstitutionModel(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val location: String,
    val favorite: Boolean = false
)