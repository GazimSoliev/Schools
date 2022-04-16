package com.gazim.school.di

import com.gazim.school.presentation.features.home.HomeViewModel
import com.gazim.school.presentation.features.institution.favorites.FavoriteInstitutionListViewModel
import com.gazim.school.presentation.features.institution.list.InstitutionListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {
        InstitutionListViewModel(
            getAllInstitutionsUseCase = get(),
            addFavoriteInstitutionsUseCase = get(),
            removeFavoriteInstitutionsUseCase = get(),
            getFilteredAllInstitutionsUseCase = get(),
            institutionSearchRequestRepository = get()
        )
    }

    viewModel {
        FavoriteInstitutionListViewModel(
            getFavoriteInstitutionsUseCase = get(),
            removeFavoriteInstitutionsUseCase = get(),
            getFilteredFavoriteInstitutionsUseCase = get(),
            institutionSearchRequestRepository = get()
        )
    }

    viewModel {
        HomeViewModel(
            institutionSearchRequestRepository = get()
        )
    }
}