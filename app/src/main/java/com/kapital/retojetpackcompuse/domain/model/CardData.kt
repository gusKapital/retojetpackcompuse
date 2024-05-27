package com.kapital.retojetpackcompuse.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardData(
    val id: Long?,
    val name: String?,
    val type: String?,
    val frameType: String?,
    val desc: String?,
    val atk: Int?,
    val def: Int?,
    val level: Int?,
    val race: String?,
    val attribute: String?,
    val archetype: String?,
    val ygoprodeck_url: String?,
    val card_sets: List<CardSet>?,
    val card_images: List<CardImage>,
    val card_prices: List<CardPrice>
): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}