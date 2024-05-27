package com.kapital.retojetpackcompuse.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardSet(
    val set_name: String,
    val set_code: String,
    val set_rarity: String,
    val set_rarity_code: String,
    val set_price: String
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}
