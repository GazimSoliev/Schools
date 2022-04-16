package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class GetFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFavoriteInstitutionsUseCase {

    override suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter {
                it.favorite
            }
        }
}