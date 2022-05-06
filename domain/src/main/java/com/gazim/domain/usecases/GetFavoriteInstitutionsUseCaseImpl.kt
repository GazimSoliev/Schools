package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class GetFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFavoriteInstitutionsUseCase {

    override suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter { it.favorite }
        }

}