package com.schools.magnitogorsk.presentation.features.institution

import androidx.recyclerview.widget.DiffUtil


class InstitutionDiffCallBack : DiffUtil.ItemCallback<Institution>() {

    override fun areItemsTheSame(oldItem: Institution, newItem: Institution): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Institution, newItem: Institution): Boolean =
        oldItem == newItem

}