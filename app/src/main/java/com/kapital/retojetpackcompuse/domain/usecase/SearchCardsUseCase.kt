package com.kapital.retojetpackcompuse.domain.usecase

import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.repository.CardRepository
import javax.inject.Inject

class SearchCardsUseCase @Inject constructor(
    private val cardRepository: CardRepository
) {
    suspend operator fun invoke(query: String, type: String): List<CardData> {
        return cardRepository.searchCards(query, type)
    }
}