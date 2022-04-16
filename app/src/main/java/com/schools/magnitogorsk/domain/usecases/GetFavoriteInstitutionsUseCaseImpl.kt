package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


class GetFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFavoriteInstitutionsUseCase {

    override suspend fun getFavoriteInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter { it.favorite }
        }

}