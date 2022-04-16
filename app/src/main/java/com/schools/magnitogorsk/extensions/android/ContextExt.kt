package com.schools.magnitogorsk.extensions.android

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes


fun Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, getString(id), duration).show()
}

fun Context.toast(string: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, string, duration).show()
}
