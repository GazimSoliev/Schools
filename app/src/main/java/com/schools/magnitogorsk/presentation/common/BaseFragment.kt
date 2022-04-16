@file:Suppress("SpellCheckingInspection")

package com.schools.magnitogorsk.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.orbitmvi.orbit.viewmodel.observe


private typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T


abstract class BaseFragment<ACTION : IAction, STATE : IState, SIDE_EFFECT : ISideEffect,
        VIEWMODEL : BaseViewModel<ACTION, STATE, SIDE_EFFECT>, VIEW_BINDING : ViewBinding>(
    private val inflate: Inflate<VIEW_BINDING>
) : Fragment() {

    private var _binding: VIEW_BINDING? = null
    protected val binding get() = _binding!!

    protected abstract val viewModel: VIEWMODEL

    protected abstract fun render(state: STATE)
    protected abstract fun handleSideEffect(sideEffect: SIDE_EFFECT)

    protected fun sendAction(action: ACTION) {
        viewModel.handleAction(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflate.invoke(inflater, container, false).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observe(
            viewLifecycleOwner,
            state = ::render,
            sideEffect = ::handleSideEffect
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}