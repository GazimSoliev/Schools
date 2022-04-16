package com.gazim.school.presentation.features.institution.list

import com.gazim.school.domain.repositories.IInstitutionSearchRequestRepository
import com.gazim.school.domain.usecases.IAddFavoriteInstitutionsUseCase
import com.gazim.school.domain.usecases.IGetAllInstitutionsUseCase
import com.gazim.school.domain.usecases.IGetFilteredAllInstitutionsUseCase
import com.gazim.school.domain.usecases.IRemoveFavoriteInstitutionsUseCase
import com.gazim.school.presentation.common.BaseViewModel
import com.gazim.school.presentation.features.institution.Institution
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container


class InstitutionListViewModel(
    private val getAllInstitutionsUseCase: IGetAllInstitutionsUseCase,
    private val addFavoriteInstitutionsUseCase: IAddFavoriteInstitutionsUseCase,
    private val removeFavoriteInstitutionsUseCase: IRemoveFavoriteInstitutionsUseCase,
    private val getFilteredAllInstitutionsUseCase: IGetFilteredAllInstitutionsUseCase,
    private val institutionSearchRequestRepository: IInstitutionSearchRequestRepository
) : BaseViewModel<InstitutionListAction, InstitutionListState, InstitutionListSideEffect>() {

    override val container = container<InstitutionListState, InstitutionListSideEffect>(
        initialState = InstitutionListState(),
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
                getAllInstitutionsUseCase.getInstitutions().onSuccess { result ->
                    reduce {
                        state.copy(
                            empty = result.isEmpty(),
                            institutions = result.map { Institution.mapFromDomain(it) })
                    }
                }.onFailure {
                    postSideEffect(InstitutionListSideEffect.Toast("$it"))
                }
            }
            else -> {
                getFilteredAllInstitutionsUseCase.getFilteredInstitutions(request)
                    .onSuccess { result ->
                        reduce {
                            state.copy(
                                institutions = result.map { Institution.mapFromDomain(it) })
                        }
                    }.onFailure {
                    postSideEffect(InstitutionListSideEffect.Toast("$it"))
                }
            }
        }
    }

    override fun handleAction(action: InstitutionListAction) = intent {
        when (action) {
            is InstitutionListAction.OnFavoriteButtonClicked -> {
                val institution = state.institutions.first { it.id == action.id }
                when (institution.favorite) {
                    true -> removeFavoriteInstitutionsUseCase.removeFavorite(institution.mapToDomain)
                    false -> addFavoriteInstitutionsUseCase.addFavorite(institution.mapToDomain)
                }
                getData(institutionSearchRequestRepository.getSearchRequest().first())
            }
            is InstitutionListAction.OnLocationButtonCLicked -> {
                postSideEffect(
                    InstitutionListSideEffect.OpenUrl(
                        "geo:${state.institutions.first { action.id == it.id }.location}?z=18"
                    )
                )
            }
            InstitutionListAction.OnResumed -> {
                reduce { state.copy(rendered = true) }
                getData(
                    institutionSearchRequestRepository.getSearchRequest().first()
                )
            }
            InstitutionListAction.OnPaused -> reduce { state.copy(rendered = false) }
        }
    }
}