package com.kapital.retojetpackcompuse.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardImage(
    val id: Long,
    val image_url: String,
    val image_url_small: String,
    val image_url_cropped: String
): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}

