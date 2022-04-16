package com.schools.magnitogorsk.presentation.features.institution.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.schools.magnitogorsk.presentation.features.institution.Institution
import com.schools.magnitogorsk.presentation.features.institution.InstitutionDiffCallBack
import com.schools.magnitogorsk.presentation.features.institution.InstitutionViewHolder
import schools.magnitogorsk.databinding.ItemBinding


class InstitutionListAdapter(
    private val onLocationButtonClick: (Int) -> Unit,
    private val onClickFavorite: (Int) -> Unit
) : ListAdapter<Institution, InstitutionViewHolder>(InstitutionDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstitutionViewHolder {
        val binding = ItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return InstitutionViewHolder(
            binding = binding,
            onLocationButtonClick = onLocationButtonClick,
            onClickFavorite = onClickFavorite
        )
    }

    override fun onBindViewHolder(holder: InstitutionViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

}