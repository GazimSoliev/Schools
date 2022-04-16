package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IGetFilteredAllInstitutionsUseCase {
    suspend fun getFilteredInstitutions(predicate: String): Result<List<InstitutionModel>>
}