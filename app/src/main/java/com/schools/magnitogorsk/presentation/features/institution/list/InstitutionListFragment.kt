package com.schools.magnitogorsk.presentation.features.institution.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.schools.magnitogorsk.extensions.android.toast
import com.schools.magnitogorsk.presentation.common.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import schools.magnitogorsk.databinding.FragmentInstitutionListBinding


class InstitutionListFragment :
    BaseFragment<InstitutionListAction, InstitutionListState, InstitutionListSideEffect,
            InstitutionListViewModel, FragmentInstitutionListBinding>(
        FragmentInstitutionListBinding::inflate
    ) {

    private val institutionAdapter = InstitutionListAdapter(
        onLocationButtonClick = {
            sendAction(InstitutionListAction.OnLocationButtonCLicked(it))
        },
        onClickFavorite = {
            sendAction(InstitutionListAction.OnFavoriteButtonClicked(it))
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
        sendAction(InstitutionListAction.OnResumed)
    }

    override fun onPause() {
        super.onPause()
        sendAction(InstitutionListAction.OnPaused)
    }

}