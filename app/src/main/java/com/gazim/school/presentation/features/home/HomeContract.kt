package com.gazim.school.presentation.features.home

import com.gazim.school.presentation.common.IAction
import com.gazim.school.presentation.common.ISideEffect
import com.gazim.school.presentation.common.IState


data class HomeState(
    val searchRequest: String = ""
) : IState

sealed class HomeSideEffect : ISideEffect {
    data class Toast(val message: String) : HomeSideEffect()
}

sealed class HomeAction : IAction {
    data class OnSearchRequest(val query: String) : HomeAction()
}
