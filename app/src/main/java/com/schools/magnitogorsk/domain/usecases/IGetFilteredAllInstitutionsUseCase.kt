package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IGetFilteredAllInstitutionsUseCase {

    suspend fun getFilteredInstitutions(query: String): Result<List<InstitutionModel>>

}