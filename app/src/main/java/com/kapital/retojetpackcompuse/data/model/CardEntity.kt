package com.kapital.retojetpackcompuse.data.model

import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.model.CardImage
import com.kapital.retojetpackcompuse.domain.model.CardPrice
import com.kapital.retojetpackcompuse.domain.model.CardSet

data class CardEntity(
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
    val card_sets: List<CardSetEntity>?,
    val card_images: List<CardImageEntity>?,
    val card_prices: List<CardPriceEntity>?
)

data class CardSetEntity(
    val set_name: String,
    val set_code: String,
    val set_rarity: String,
    val set_rarity_code: String,
    val set_price: String
)

data class CardImageEntity(
    val id: Long,
    val image_url: String,
    val image_url_small: String,
    val image_url_cropped: String
)

data class CardPriceEntity(
    val cardmarket_price: String,
    val tcgplayer_price: String,
    val ebay_price: String,
    val amazon_price: String,
    val coolstuffinc_price: String
)

fun CardEntity.toDomain(): CardData {
    return CardData(
        id = id,
        name = name,
        type = type,
        frameType = frameType,
        desc = desc,
        atk = atk,
        def = def,
        level = level,
        race = race,
        attribute = attribute,
        archetype = archetype,
        ygoprodeck_url = ygoprodeck_url,
        card_sets = card_sets?.map { it.toDomain() },
        card_images = card_images!!.map { it.toDomain() },
        card_prices = card_prices!!.map { it.toDomain() }
    )
}

fun CardSetEntity.toDomain(): CardSet {
    return CardSet(
        set_name = set_name,
        set_code = set_code,
        set_rarity = set_rarity,
        set_rarity_code = set_rarity_code,
        set_price = set_price
    )
}

fun CardImageEntity.toDomain(): CardImage {
    return CardImage(
        id = id,
        image_url = image_url,
        image_url_small = image_url_small,
        image_url_cropped = image_url_cropped
    )
}

fun CardPriceEntity.toDomain(): CardPrice {
    return CardPrice(
        cardmarket_price = cardmarket_price,
        tcgplayer_price = tcgplayer_price,
        ebay_price = ebay_price,
        amazon_price = amazon_price,
        coolstuffinc_price = coolstuffinc_price
    )
}