package com.schools.magnitogorsk.di

import com.gazim.data.repositories.InstitutionRepositoryImpl
import com.gazim.data.repositories.InstitutionSearchRequestRepositoryImpl
import com.gazim.domain.repositories.IInstitutionRepository
import com.gazim.domain.repositories.IInstitutionSearchRequestRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<IInstitutionRepository> {
        InstitutionRepositoryImpl(institutionsDao = get())
    }

    single<IInstitutionSearchRequestRepository> {
        InstitutionSearchRequestRepositoryImpl()
    }

}