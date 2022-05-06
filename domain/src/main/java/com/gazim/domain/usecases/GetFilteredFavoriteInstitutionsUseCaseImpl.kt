package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class GetFilteredFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFilteredFavoriteInstitutionsUseCase {

    override suspend fun getFilteredFavoriteInstitutions(query: String): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter {
                it.favorite && (it.title.containsIgnoringCaps(query) || it.description.containsIgnoringCaps(query))
            }
        }

    private fun String.containsIgnoringCaps(str: String): Boolean =
        this.lowercase().contains(str.lowercase())

}