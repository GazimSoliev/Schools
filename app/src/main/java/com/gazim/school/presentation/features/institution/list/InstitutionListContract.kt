package com.gazim.school.presentation.features.institution.list

import com.gazim.school.presentation.common.IAction
import com.gazim.school.presentation.common.ISideEffect
import com.gazim.school.presentation.common.IState
import com.gazim.school.presentation.features.institution.Institution


data class InstitutionListState(
    val rendered: Boolean = false,
    val empty: Boolean = false,
    val institutions: List<Institution> = emptyList()
): IState

sealed class InstitutionListSideEffect: ISideEffect {
    data class Toast(val message: String): InstitutionListSideEffect()
    data class OpenUrl(val url: String): InstitutionListSideEffect()
}

sealed class InstitutionListAction: IAction {
    data class OnLocationButtonCLicked(val id: Int): InstitutionListAction()
    data class OnFavoriteButtonClicked(val id: Int): InstitutionListAction()
    object OnResumed: InstitutionListAction()
    object OnPaused: InstitutionListAction()
}