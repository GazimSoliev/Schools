package com.gazim.domain.repositories

import com.gazim.domain.models.InstitutionModel


interface IInstitutionRepository {
    suspend fun getInstitutions(): List<InstitutionModel>
    suspend fun updateInstitution(institutionModel: InstitutionModel)
}