package com.schools.magnitogorsk.presentation.features.home

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.schools.magnitogorsk.extensions.android.toast
import com.schools.magnitogorsk.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import schools.magnitogorsk.R
import schools.magnitogorsk.databinding.FragmentHomeBinding


class HomeFragment :
    BaseFragment<HomeAction, HomeState, HomeSideEffect, HomeViewModel, FragmentHomeBinding>(
        FragmentHomeBinding::inflate
    ) {

    override val viewModel: HomeViewModel by viewModel()

    override fun render(state: HomeState) {

    }

    override fun handleSideEffect(sideEffect: HomeSideEffect) {
        when (sideEffect) {
            is HomeSideEffect.Toast -> toast(sideEffect.message)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etSearch.addTextChangedListener { editable ->
            editable?.let { viewModel.handleAction(HomeAction.OnSearchRequest(it.toString())) }
        }
        binding.viewPager.adapter = HomeViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> tab.setText(R.string.tabLayoutTextFavorite)
                else -> tab.setText(R.string.tabLayoutTextAll)
            }
        }.attach()
    }

}