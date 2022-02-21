package com.codesquad.kotlinphotoframe

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun String.Snackbar(contextView: View) {
    Snackbar.make(contextView, this, Snackbar.LENGTH_SHORT).show()
}
