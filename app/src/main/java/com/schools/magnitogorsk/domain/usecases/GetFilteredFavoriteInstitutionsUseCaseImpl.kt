package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


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