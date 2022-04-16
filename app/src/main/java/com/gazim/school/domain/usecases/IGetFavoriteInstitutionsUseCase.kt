package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel


interface IGetFavoriteInstitutionsUseCase {
    suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>>
}