package com.kapital.retojetpackcompuse.ui.navigation

import com.kapital.retojetpackcompuse.domain.model.CardData

object Routes {

    const val CARD_LIST = "cardList"
    const val SEARCH_SCREEN = "searchScreen"
    const val CARD_DETAIL = "cardDetail"

    fun cardDetailRoute(card: CardData) = "$CARD_DETAIL/${card.id}"
}