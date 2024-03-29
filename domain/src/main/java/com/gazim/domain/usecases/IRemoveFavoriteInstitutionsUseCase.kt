package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IRemoveFavoriteInstitutionsUseCase {

    suspend fun removeFavorite(institutionModel: InstitutionModel): Result<Unit>

}