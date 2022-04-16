package com.gazim.school.di

import com.gazim.school.data.repositories.InstitutionRepositoryImpl
import com.gazim.school.data.repositories.InstitutionSearchRequestRepositoryImpl
import com.gazim.school.domain.repositories.IInstitutionRepository
import com.gazim.school.domain.repositories.IInstitutionSearchRequestRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<IInstitutionRepository> {
        InstitutionRepositoryImpl(institutionsDao = get(), dataSourceFromAssert = get())
    }

    single<IInstitutionSearchRequestRepository> {
        InstitutionSearchRequestRepositoryImpl()
    }
}