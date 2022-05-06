package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel


interface IGetFavoriteInstitutionsUseCase {

    suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>>

}