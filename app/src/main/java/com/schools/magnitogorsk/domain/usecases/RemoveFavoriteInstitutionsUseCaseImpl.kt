package com.schools.magnitogorsk.domain.usecases

import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


class RemoveFavoriteInstitutionsUseCaseImpl(private val institutionRepository: IInstitutionRepository) :
    IRemoveFavoriteInstitutionsUseCase {

    override suspend fun removeFavorite(institutionModel: InstitutionModel) = runCatching {
        institutionRepository.updateInstitution(institutionModel.copy(favorite = false))
    }

}