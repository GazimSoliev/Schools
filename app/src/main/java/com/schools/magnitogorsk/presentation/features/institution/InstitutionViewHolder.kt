package com.schools.magnitogorsk.presentation.features.institution

import android.graphics.drawable.Drawable
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import schools.magnitogorsk.R
import schools.magnitogorsk.databinding.ItemBinding

class InstitutionViewHolder(
    private val binding: ItemBinding, private val onLocationButtonClick: (Int) -> Unit,
    private val onClickFavorite: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(institution: Institution) {
        with(binding) {
            runCatching {
                Drawable.createFromStream(root.context.assets.open(institution.image), null)
            }.onSuccess {
                Glide.with(itemView.context)
                    .load(it)
                    .override(eduImage.width).into(eduImage)
                eduImage.isVisible = true
            }.onFailure {
                eduImage.isVisible = false
            }
            if (institution.favorite) {
                buttonFavorite.setText(R.string.buttonFavoriteAddedText)
                buttonFavorite.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_baseline_star_24, 0, 0, 0
                )
            } else {
                buttonFavorite.setText(R.string.buttonFavoriteAddText)
                buttonFavorite.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_baseline_star_border_24, 0, 0, 0
                )
            }
            eduTitle.isVisible = institution.title.isNotBlank()
            eduTitle.text = institution.title
            eduDescription.isVisible = institution.description.isNotBlank()
            eduDescription.text = institution.description
            buttonLookAtMap.setOnClickListener {
                onLocationButtonClick(institution.id)
            }
            buttonFavorite.setOnClickListener {
                onClickFavorite(institution.id)
            }
        }
    }

}