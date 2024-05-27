package com.kapital.retojetpackcompuse.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.presentation.viewmodel.CardViewModel
import com.kapital.retojetpackcompuse.ui.components.CardItemYugioh
import com.kapital.retojetpackcompuse.ui.screens.SearchScreen
import com.kapital.retojetpackcompuse.ui.screens.detailsCards.CardDetailScreen
import com.kapital.retojetpackcompuse.ui.screens.home.CardListScreen
import kotlinx.coroutines.launch


@Composable
fun NavGraph(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier, cardViewModel: CardViewModel = hiltViewModel()) {

    NavHost(navController = navController, startDestination = Routes.CARD_LIST, modifier = modifier) {

        composable(Routes.CARD_LIST) {
            CardListScreen(navController = navController, cardViewModel = cardViewModel)
        }

        composable(route = "${Routes.CARD_DETAIL}/{cardId}", arguments = listOf(navArgument("cardId") { type = NavType.LongType })) { backStackEntry ->

            val cardId = backStackEntry.arguments?.getLong("cardId")
            var card by remember { mutableStateOf<CardData?>(null) }
            val scope = rememberCoroutineScope()

            LaunchedEffect(cardId) {
                cardId?.let {
                    scope.launch {
                        card = cardViewModel.getCardById(it)!!
                    }
                }
            }

            card?.let {
                CardDetailScreen(card = it)
            }

        }
    }
}


