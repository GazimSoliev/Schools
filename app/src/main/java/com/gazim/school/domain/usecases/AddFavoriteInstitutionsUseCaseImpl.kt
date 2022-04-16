package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class AddFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IAddFavoriteInstitutionsUseCase {
    override suspend fun addFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = true))
    }
}