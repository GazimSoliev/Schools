package com.gazim.domain.usecases

import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class AddFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IAddFavoriteInstitutionsUseCase {

    override suspend fun addFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = true))
    }

}