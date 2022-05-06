package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class RemoveFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IRemoveFavoriteInstitutionsUseCase {

    override suspend fun removeFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = false))
    }

}