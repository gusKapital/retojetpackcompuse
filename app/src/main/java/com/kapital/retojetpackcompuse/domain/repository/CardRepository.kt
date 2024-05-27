package com.kapital.retojetpackcompuse.domain.repository

import com.kapital.retojetpackcompuse.domain.model.CardData

interface CardRepository {
    suspend fun getCards(): List<CardData>
    suspend fun getCardbyId(id: Long): CardData?
    suspend fun searchCards(query: String, type: String): List<CardData>
}