package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class GetFilteredFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IGetFilteredFavoriteInstitutionsUseCase {

    override suspend fun getFilteredFavoriteInstitutions(predicate: String): Result<List<InstitutionModel>> =
        runCatching {
            institutionRepository.getInstitutions().filter {
                it.favorite && (it.title.lowercase().contains(predicate) || it.description.lowercase().contains(predicate))
            }
        }
}