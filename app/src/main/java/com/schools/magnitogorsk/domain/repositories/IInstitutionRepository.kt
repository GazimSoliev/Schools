package com.schools.magnitogorsk.domain.repositories

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IInstitutionRepository {
    suspend fun getInstitutions(): List<InstitutionModel>
    suspend fun updateInstitution(institutionModel: InstitutionModel)
}