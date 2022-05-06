package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IGetAllInstitutionsUseCase {

    suspend fun getInstitutions(): Result<List<InstitutionModel>>

}