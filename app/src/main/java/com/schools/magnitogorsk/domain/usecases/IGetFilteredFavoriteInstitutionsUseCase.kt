package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IGetFilteredFavoriteInstitutionsUseCase {

    suspend fun getFilteredFavoriteInstitutions(query: String): Result<List<InstitutionModel>>

}