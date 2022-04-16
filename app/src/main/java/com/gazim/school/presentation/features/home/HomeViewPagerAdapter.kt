package com.gazim.school.presentation.features.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gazim.school.presentation.features.institution.favorites.FavoriteInstitutionListFragment
import com.gazim.school.presentation.features.institution.list.InstitutionListFragment


class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> FavoriteInstitutionListFragment()
            else -> InstitutionListFragment()
        }
}