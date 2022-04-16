package com.gazim.school.presentation.features.institution.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.gazim.school.databinding.FragmentInstitutionListBinding
import com.gazim.school.extensions.android.toast
import com.gazim.school.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class InstitutionListFragment :
    BaseFragment<InstitutionListAction, InstitutionListState, InstitutionListSideEffect,
            InstitutionListViewModel, FragmentInstitutionListBinding>(
        FragmentInstitutionListBinding::inflate
    ) {

    private val institutionAdapter = InstitutionListAdapter(
        onLocationButtonClick = {
            viewModel.handleAction(InstitutionListAction.OnLocationButtonCLicked(it))
        },
        onClickFavorite = {
            viewModel.handleAction(InstitutionListAction.OnFavoriteButtonClicked(it))
        }
    )

    override val viewModel: InstitutionListViewModel by viewModel()

    override fun render(state: InstitutionListState) {
        binding.tvEmptyList.isVisible = state.empty
        binding.rvAllInstitutions.isVisible = !state.empty
        institutionAdapter.submitList(state.institutions)
    }

    override fun handleSideEffect(sideEffect: InstitutionListSideEffect) {
        when (sideEffect) {
            is InstitutionListSideEffect.Toast -> toast(sideEffect.message)
            is InstitutionListSideEffect.OpenUrl -> {
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
        binding.rvAllInstitutions.adapter = institutionAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.handleAction(InstitutionListAction.OnResumed)
    }

    override fun onPause() {
        super.onPause()
        viewModel.handleAction(InstitutionListAction.OnPaused)
    }

}