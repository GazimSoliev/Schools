package com.gazim.data.repositories

import com.gazim.data.database.dao.InstitutionsDao
import com.gazim.data.database.entities.InstitutionEntity
import com.gazim.domain.models.InstitutionModel
import com.gazim.domain.repositories.IInstitutionRepository


class InstitutionRepositoryImpl(
    private val institutionsDao: InstitutionsDao
) : IInstitutionRepository {

    override suspend fun getInstitutions(): List<InstitutionModel> =
        institutionsDao.getAll().map { it.mapToDomain }


    override suspend fun updateInstitution(institutionModel: InstitutionModel) =
        institutionsDao.update(InstitutionEntity.mapFromDomain(institutionModel))

}