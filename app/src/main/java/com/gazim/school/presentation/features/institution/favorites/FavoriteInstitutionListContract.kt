package com.gazim.school.presentation.features.institution.favorites

import com.gazim.school.presentation.common.IAction
import com.gazim.school.presentation.common.ISideEffect
import com.gazim.school.presentation.common.IState
import com.gazim.school.presentation.features.institution.Institution


data class FavoriteInstitutionListState(
    val rendered: Boolean = false,
    val empty: Boolean = false,
    val institutions: List<Institution> = emptyList()
): IState

sealed class FavoriteInstitutionListSideEffect: ISideEffect {
    data class Toast(val message: String): FavoriteInstitutionListSideEffect()
    data class OpenUrl(val url: String): FavoriteInstitutionListSideEffect()
}

sealed class FavoriteInstitutionListAction: IAction {
    data class OnLocationButtonCLicked(val id: Int): FavoriteInstitutionListAction()
    data class OnFavoriteButtonCLicked(val id: Int): FavoriteInstitutionListAction()
    object OnResumed: FavoriteInstitutionListAction()
    object OnPaused: FavoriteInstitutionListAction()
}