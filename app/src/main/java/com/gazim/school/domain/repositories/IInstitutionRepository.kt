package com.gazim.school.domain.repositories

import com.gazim.school.domain.models.InstitutionModel


interface IInstitutionRepository {
    suspend fun getInstitutions(): List<InstitutionModel>
    suspend fun updateInstitution(institutionModel: InstitutionModel)
}