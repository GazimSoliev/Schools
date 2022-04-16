package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class GetAllInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetAllInstitutionsUseCase {

    override suspend fun getInstitutions(): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions()
        }
}