package com.schools.magnitogorsk.data.repositories

import com.schools.magnitogorsk.data.database.dao.InstitutionsDao
import com.schools.magnitogorsk.data.database.entities.InstitutionEntity
import com.schools.magnitogorsk.domain.models.InstitutionModel
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository


class InstitutionRepositoryImpl(
    private val institutionsDao: InstitutionsDao
) : IInstitutionRepository {

    override suspend fun getInstitutions(): List<InstitutionModel> =
        institutionsDao.getAll().map { it.mapToDomain }


    override suspend fun updateInstitution(institutionModel: InstitutionModel) =
        institutionsDao.update(InstitutionEntity.mapFromDomain(institutionModel))


}