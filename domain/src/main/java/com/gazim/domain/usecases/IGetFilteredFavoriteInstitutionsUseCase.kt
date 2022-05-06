package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IGetFilteredFavoriteInstitutionsUseCase {

    suspend fun getFilteredFavoriteInstitutions(query: String): Result<List<InstitutionModel>>

}