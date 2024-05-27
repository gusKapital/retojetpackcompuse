package com.kapital.retojetpackcompuse.domain.usecase

import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.repository.CardRepository
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val cardRepository: CardRepository) {

    suspend operator fun invoke(): List<CardData> {
        return cardRepository.getCards()
    }
}