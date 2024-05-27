package com.kapital.retojetpackcompuse.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.presentation.viewmodel.CardViewModel
import com.kapital.retojetpackcompuse.ui.components.CardItemYugioh
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, cardViewModel: CardViewModel = hiltViewModel()) {

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf("All", "Spell Cards", "Monsters")

    val scope = rememberCoroutineScope()

    var searchResults by remember { mutableStateOf<List<CardData?>>(emptyList()) }


    Column(modifier = Modifier.fillMaxSize()) {
        // Toolbar
        TopAppBar(
            title = { Text("Search Cards") },
            modifier = Modifier.fillMaxWidth()
        )

        // Search CardView
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation =  CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Tabs
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        // Search Results
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(searchResults) { card ->
                CardItemYugioh(card = card!!, navController = navController)
            }
        }
    }

    LaunchedEffect(searchQuery, selectedTab) {
        scope.launch {
            searchResults = when (selectedTab) {
                1 -> cardViewModel.searchCards(searchQuery.text, "Spell")
                2 -> cardViewModel.searchCards(searchQuery.text, "Monster")
                else -> cardViewModel.searchCards(searchQuery.text, "All")
            }
        }
    }
}