package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IRemoveFavoriteInstitutionsUseCase {

    suspend fun removeFavorite(institutionModel: InstitutionModel): Result<Unit>

}