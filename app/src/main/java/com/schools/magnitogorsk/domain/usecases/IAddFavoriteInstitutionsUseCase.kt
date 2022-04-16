package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IAddFavoriteInstitutionsUseCase {
    suspend fun addFavorite(institutionModel: InstitutionModel): Result<Unit>
}