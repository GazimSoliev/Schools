package com.gazim.school.data.repositories

import com.gazim.school.data.database.dao.InstitutionsDao
import com.gazim.school.data.database.entities.InstitutionEntity
import com.gazim.school.data.datasource.IDataSourceFromAssert
import com.gazim.school.domain.models.InstitutionModel
import com.gazim.school.domain.repositories.IInstitutionRepository


class InstitutionRepositoryImpl(
    private val institutionsDao: InstitutionsDao,
    private val dataSourceFromAssert: IDataSourceFromAssert
) :
    IInstitutionRepository {

    override suspend fun getInstitutions(): List<InstitutionModel> {
        if (institutionsDao.getAll().isEmpty()) {
            institutionsDao.insertAll(
                dataSourceFromAssert.getInstitutions().map { InstitutionEntity.mapFromAssets(it) })
        }
        return institutionsDao.getAll().map { it.mapToDomain }
    }


    override suspend fun updateInstitution(institutionModel: InstitutionModel) {
        institutionsDao.update(InstitutionEntity.mapFromDomain(institutionModel))
    }

}