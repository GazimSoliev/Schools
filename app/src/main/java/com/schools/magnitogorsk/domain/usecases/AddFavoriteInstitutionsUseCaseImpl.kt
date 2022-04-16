package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


class AddFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IAddFavoriteInstitutionsUseCase {

    override suspend fun addFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = true))
    }

}