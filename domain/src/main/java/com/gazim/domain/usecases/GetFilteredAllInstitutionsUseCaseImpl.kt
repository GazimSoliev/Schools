package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class GetFilteredAllInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFilteredAllInstitutionsUseCase {

    override suspend fun getFilteredInstitutions(query: String): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter {
                it.title.containsIgnoringCaps(query) || it.description.containsIgnoringCaps(query)
            }
        }

    private fun String.containsIgnoringCaps(str: String): Boolean =
        this.lowercase().contains(str.lowercase())

}