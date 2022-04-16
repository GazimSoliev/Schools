package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IRemoveFavoriteInstitutionsUseCase {
    suspend fun removeFavorite(institutionModel: InstitutionModel): Result<Unit>
}