package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel


interface IGetAllInstitutionsUseCase {

    suspend fun getInstitutions(): Result<List<InstitutionModel>>

}