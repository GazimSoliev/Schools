package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


class GetAllInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetAllInstitutionsUseCase {

    override suspend fun getInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions()
        }

}