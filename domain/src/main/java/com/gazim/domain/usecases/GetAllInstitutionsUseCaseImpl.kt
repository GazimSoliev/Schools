package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class GetAllInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetAllInstitutionsUseCase {

    override suspend fun getInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions()
        }

}