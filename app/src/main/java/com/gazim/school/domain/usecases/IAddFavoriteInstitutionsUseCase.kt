package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IAddFavoriteInstitutionsUseCase {
    suspend fun addFavorite(institutionModel: InstitutionModel): Result<Unit>
}