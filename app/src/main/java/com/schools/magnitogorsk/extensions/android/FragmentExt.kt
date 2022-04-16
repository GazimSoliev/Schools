package com.schools.magnitogorsk.extensions.android

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


fun Fragment.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    this.requireContext().toast(getString(id), duration)
}

fun Fragment.toast(string: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    this.requireContext().toast(string, duration)
}