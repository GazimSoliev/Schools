package com.schools.magnitogorsk.presentation.features.institution.favorites

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.schools.magnitogorsk.extensions.android.toast
import com.schools.magnitogorsk.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import schools.magnitogorsk.R
import schools.magnitogorsk.databinding.FragmentFavoriteInstitutionListBinding


class FavoriteInstitutionListFragment :
    BaseFragment<FavoriteInstitutionListAction, FavoriteInstitutionListState, FavoriteInstitutionListSideEffect, FavoriteInstitutionListViewModel, FragmentFavoriteInstitutionListBinding>(
        FragmentFavoriteInstitutionListBinding::inflate
    ) {

    private val favoriteInstitutionAdapter = FavoriteInstitutionListAdapter(
        onLocationButtonClick = {
            sendAction(FavoriteInstitutionListAction.OnLocationButtonCLicked(it))
        },
        onClickFavorite = {
            sendAction(FavoriteInstitutionListAction.OnFavoriteButtonCLicked(it))
        }
    )

    override val viewModel: FavoriteInstitutionListViewModel by viewModel()

    override fun render(state: FavoriteInstitutionListState) {
        binding.buttonGoToTheList.isVisible = state.empty
        binding.rvFavoriteInstitutions.isVisible = !state.empty
        favoriteInstitutionAdapter.submitList(state.institutions)
    }

    override fun handleSideEffect(sideEffect: FavoriteInstitutionListSideEffect) {
        when (sideEffect) {
            is FavoriteInstitutionListSideEffect.Toast -> toast(sideEffect.message)
            is FavoriteInstitutionListSideEffect.OpenUrl -> {
                val mapIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(sideEffect.url)
                )
                if (mapIntent.resolveActivity(requireActivity().packageManager) != null)
                    requireActivity().startActivity(mapIntent)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavoriteInstitutions.adapter = favoriteInstitutionAdapter
        binding.buttonGoToTheList.setOnClickListener {
            requireActivity().findViewById<ViewPager2>(R.id.viewPager).currentItem = 1
        }
    }

    override fun onResume() {
        super.onResume()
        sendAction(FavoriteInstitutionListAction.OnResumed)
    }

    override fun onPause() {
        super.onPause()
        sendAction(FavoriteInstitutionListAction.OnPaused)
    }

}