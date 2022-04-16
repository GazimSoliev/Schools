package com.schools.magnitogorsk.presentation.features.home

import com.schools.magnitogorsk.presentation.common.IAction
import com.schools.magnitogorsk.presentation.common.ISideEffect
import com.schools.magnitogorsk.presentation.common.IState


data class HomeState(
    val searchRequest: String = ""
) : IState

sealed class HomeSideEffect : ISideEffect {
    data class Toast(val message: String) : HomeSideEffect()
}

sealed class HomeAction : IAction {
    data class OnSearchRequest(val query: String) : HomeAction()
}
