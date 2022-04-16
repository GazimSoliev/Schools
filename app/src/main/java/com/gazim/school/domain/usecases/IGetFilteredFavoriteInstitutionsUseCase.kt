package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IGetFilteredFavoriteInstitutionsUseCase {
    suspend fun getFilteredFavoriteInstitutions(predicate: String): Result<List<InstitutionModel>>
}