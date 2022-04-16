package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IGetAllInstitutionsUseCase {
    suspend fun getInstitutions(): Result<List<InstitutionModel>>
}