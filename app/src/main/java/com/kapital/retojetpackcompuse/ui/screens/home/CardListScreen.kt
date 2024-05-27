package com.kapital.retojetpackcompuse.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.model.CardImage
import com.kapital.retojetpackcompuse.domain.model.CardPrice
import com.kapital.retojetpackcompuse.domain.model.CardSet
import com.kapital.retojetpackcompuse.presentation.viewmodel.CardViewModel
import com.kapital.retojetpackcompuse.ui.components.CardItemYugioh
import com.kapital.retojetpackcompuse.ui.components.KapitalText
import com.kapital.retojetpackcompuse.ui.screens.detailsCards.CardDetailScreen

@Composable
fun CardListScreen(navController: NavController, cardViewModel: CardViewModel = hiltViewModel()) {
    val cards by cardViewModel.cards.collectAsState()
    val isLoading by cardViewModel.isLoading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center).wrapContentSize())
        } else {
            LazyColumn(contentPadding = PaddingValues(8.dp), modifier = Modifier.fillMaxSize()) {
                items(cards) { card ->
                    CardItemYugioh(card = card, navController = navController)
                }
            }
        }
    }
}

@Composable
fun CardListScreen(navController: NavController, cards: List<CardData>){
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(cards) { card ->
                CardItemYugioh(card = card, navController = navController)
            }
        }
    }
}
