package com.project.armovie.home.checkout

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Checkout (
    var seat: String ?="",
    var amount: String ?=""
): Parcelable