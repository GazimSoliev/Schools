package com.gazim.school.domain.usecases

import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class RemoveFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IRemoveFavoriteInstitutionsUseCase {
    override suspend fun removeFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = false))
    }
}