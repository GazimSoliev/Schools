package com.schools.magnitogorsk.di

import com.schools.magnitogorsk.data.repositories.InstitutionRepositoryImpl
import com.schools.magnitogorsk.data.repositories.InstitutionSearchRequestRepositoryImpl
import com.schools.magnitogorsk.domain.repositories.IInstitutionRepository
import com.schools.magnitogorsk.domain.repositories.IInstitutionSearchRequestRepository
import org.koin.dsl.module


val repositoryModule = module {

    single<IInstitutionRepository> {
        InstitutionRepositoryImpl(institutionsDao = get())
    }

    single<IInstitutionSearchRequestRepository> {
        InstitutionSearchRequestRepositoryImpl()
    }

}