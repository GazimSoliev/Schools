package com.schools.magnitogorsk.presentation.common

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost


abstract class BaseViewModel<ACTION : IAction, STATE : IState, SIDE_EFFECT : ISideEffect> :
    ViewModel(), ContainerHost<STATE, SIDE_EFFECT> {

    abstract fun handleAction(action: ACTION)

}