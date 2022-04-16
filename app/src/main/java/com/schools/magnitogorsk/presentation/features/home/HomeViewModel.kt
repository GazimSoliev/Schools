package com.schools.magnitogorsk.presentation.features.home

import com.schools.magnitogorsk.domain.repositories.IInstitutionSearchRequestRepository
import com.schools.magnitogorsk.presentation.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container


class HomeViewModel(private val institutionSearchRequestRepository: IInstitutionSearchRequestRepository) :
    BaseViewModel<HomeAction, HomeState, HomeSideEffect>() {

    override val container = container<HomeState, HomeSideEffect>(
        initialState = HomeState(),
        settings = Container.Settings(intentDispatcher = Dispatchers.Main)
    )

    override fun handleAction(action: HomeAction) = intent {
        when (action) {
            is HomeAction.OnSearchRequest -> institutionSearchRequestRepository.setSearchRequest(
                action.query
            )
        }
    }

}