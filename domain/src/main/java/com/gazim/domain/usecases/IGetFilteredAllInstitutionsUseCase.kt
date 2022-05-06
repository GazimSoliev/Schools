package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IGetFilteredAllInstitutionsUseCase {

    suspend fun getFilteredInstitutions(query: String): Result<List<InstitutionModel>>

}