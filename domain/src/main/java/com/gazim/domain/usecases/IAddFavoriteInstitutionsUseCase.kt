package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IAddFavoriteInstitutionsUseCase {

    suspend fun addFavorite(institutionModel: InstitutionModel): Result<Unit>

}