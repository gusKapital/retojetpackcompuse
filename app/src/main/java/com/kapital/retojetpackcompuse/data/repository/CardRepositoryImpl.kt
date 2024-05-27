package com.kapital.retojetpackcompuse.data.repository

import com.kapital.retojetpackcompuse.data.model.toDomain
import com.kapital.retojetpackcompuse.data.remote.CardApi
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val cardApi: CardApi) : CardRepository {

    private var cachedCards: List<CardData>? = null

    override suspend fun getCards(): List<CardData> {
        if (cachedCards == null){
            cachedCards = cardApi.getCards().data.map { it.toDomain() }
        }
        return cachedCards ?: emptyList()
    }

    override suspend fun getCardbyId(id: Long ): CardData? {
        return getCards().find { it.id == id }
    }

    override suspend fun searchCards(query: String, type: String): List<CardData> {
        return getCards().filter {
            it.name!!.contains(query, ignoreCase = true) && (type == "All" || it.type == type)
        }
    }
}

