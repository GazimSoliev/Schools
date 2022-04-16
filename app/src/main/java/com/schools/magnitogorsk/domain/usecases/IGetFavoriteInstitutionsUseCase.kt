package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IGetFavoriteInstitutionsUseCase {

    suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>>

}