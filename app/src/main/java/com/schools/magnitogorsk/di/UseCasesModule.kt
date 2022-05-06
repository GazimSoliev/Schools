package com.schools.magnitogorsk.di

import com.gazim.domain.usecases.*
import org.koin.dsl.module


val useCasesModule = module {

    single<IGetAllInstitutionsUseCase> {
        GetAllInstitutionsUseCaseImpl(institutionRepository = get())
    }

    single<IGetFavoriteInstitutionsUseCase> {
        GetFavoriteInstitutionsUseCaseImpl(institutionRepository = get())
    }

    single<IRemoveFavoriteInstitutionsUseCase> {
        RemoveFavoriteInstitutionsUseCaseImpl(institutionRepository = get())
    }

    single<IAddFavoriteInstitutionsUseCase> {
        AddFavoriteInstitutionsUseCaseImpl(institutionRepository = get())
    }

    single<IGetFilteredAllInstitutionsUseCase> {
        GetFilteredAllInstitutionsUseCaseImpl(institutionRepository = get())
    }

    single<IGetFilteredFavoriteInstitutionsUseCase> {
        GetFilteredFavoriteInstitutionsUseCaseImpl(institutionRepository = get())
    }

}