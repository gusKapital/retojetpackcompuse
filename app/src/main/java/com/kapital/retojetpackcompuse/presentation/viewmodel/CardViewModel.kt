package com.kapital.retojetpackcompuse.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.usecase.GetCardByIdUseCase
import com.kapital.retojetpackcompuse.domain.usecase.GetCardsUseCase
import com.kapital.retojetpackcompuse.domain.usecase.SearchCardsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val getCardByIdUseCase: GetCardByIdUseCase,
    private val searchCardsUseCase: SearchCardsUseCase
) : ViewModel() {

    private val _cards = MutableStateFlow<List<CardData>>(emptyList())
    val cards: StateFlow<List<CardData>> get() = _cards

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        fetchCards()
    }

    private fun fetchCards() {
        viewModelScope.launch {
            _isLoading.value = true
            _cards.value = getCardsUseCase()
            _isLoading.value = false
        }
    }

    suspend fun getCardById(id: Long):CardData? {
        return getCardByIdUseCase(id)
    }

    suspend fun searchCards(query: String, type: String): List<CardData> {
        return searchCardsUseCase(query, type)
    }
}