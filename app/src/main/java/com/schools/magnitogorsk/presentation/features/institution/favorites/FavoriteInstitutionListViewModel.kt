package com.schools.magnitogorsk.presentation.features.institution.favorites

import com.gazim.domain.repositories.IInstitutionSearchRequestRepository
import com.gazim.domain.usecases.IGetFavoriteInstitutionsUseCase
import com.gazim.domain.usecases.IGetFilteredFavoriteInstitutionsUseCase
import com.gazim.domain.usecases.IRemoveFavoriteInstitutionsUseCase
import com.schools.magnitogorsk.presentation.common.BaseViewModel
import com.schools.magnitogorsk.presentation.features.institution.Institution
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container


class FavoriteInstitutionListViewModel(
    private val getFavoriteInstitutionsUseCase: IGetFavoriteInstitutionsUseCase,
    private val removeFavoriteInstitutionsUseCase: IRemoveFavoriteInstitutionsUseCase,
    private val getFilteredFavoriteInstitutionsUseCase: IGetFilteredFavoriteInstitutionsUseCase,
    private val institutionSearchRequestRepository: IInstitutionSearchRequestRepository
) : BaseViewModel<FavoriteInstitutionListAction, FavoriteInstitutionListState, FavoriteInstitutionListSideEffect>() {

    override val container =
        container<FavoriteInstitutionListState, FavoriteInstitutionListSideEffect>(
            initialState = FavoriteInstitutionListState(),
            settings = Container.Settings(intentDispatcher = Dispatchers.IO)
        ) {
            intent {
                institutionSearchRequestRepository.getSearchRequest().collect {
                    if (state.rendered) getData(it)
                }
            }
        }

    private fun getData(request: String) = intent {
        reduce { state.copy(empty = false) }
        when (request.isBlank()) {
            true -> {
                getFavoriteInstitutionsUseCase.getFavoriteInstitutions()
                    .onSuccess { result ->
                        reduce {
                            state.copy(
                                empty = result.isEmpty(),
                                institutions = result.map { Institution.mapFromDomain(it) })
                        }
                    }.onFailure {
                        postSideEffect(FavoriteInstitutionListSideEffect.Toast("$it"))
                    }
            }
            else -> {
                getFilteredFavoriteInstitutionsUseCase.getFilteredFavoriteInstitutions(request)
                    .onSuccess { result ->
                        reduce {
                            state.copy(
                                institutions = result.map { Institution.mapFromDomain(it) })
                        }
                    }.onFailure {
                        postSideEffect(FavoriteInstitutionListSideEffect.Toast("$it"))
                    }
            }
        }
    }

    override fun handleAction(action: FavoriteInstitutionListAction) = intent {
        when (action) {
            is FavoriteInstitutionListAction.OnFavoriteButtonCLicked -> {
                removeFavoriteInstitutionsUseCase.removeFavorite(
                    state.institutions.first { action.id == it.id }.mapToDomain
                )
                getData(institutionSearchRequestRepository.getSearchRequest().first())
            }
            is FavoriteInstitutionListAction.OnLocationButtonCLicked -> {
                postSideEffect(
                    FavoriteInstitutionListSideEffect.OpenUrl(
                        "geo:${state.institutions.first { action.id == it.id }.location}?z=18"
                    )
                )
            }
            FavoriteInstitutionListAction.OnResumed -> {
                reduce { state.copy(rendered = true) }
                getData(institutionSearchRequestRepository.getSearchRequest().first())
            }
            FavoriteInstitutionListAction.OnPaused -> reduce { state.copy(rendered = false) }
        }
    }

}