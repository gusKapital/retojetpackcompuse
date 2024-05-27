package com.kapital.retojetpackcompuse.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.model.CardImage
import com.kapital.retojetpackcompuse.domain.model.CardPrice
import com.kapital.retojetpackcompuse.domain.model.CardSet
import com.kapital.retojetpackcompuse.ui.navigation.Routes
import com.kapital.retojetpackcompuse.ui.theme.MyAppTheme

@Composable
fun CardItemYugioh(card: CardData, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Routes.cardDetailRoute(card))
            },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C))
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            val painter: Painter =
                rememberAsyncImagePainter(model = card.card_images.first().image_url_cropped)
            Image(
                painter = painter, contentDescription = null, modifier = Modifier
                    //.height(150.dp)
                    //.width(50.dp)
                    .size(150.dp)
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                card.name?.let {
                    KapitalText(
                        fontSize = 20, fontWeight = FontWeight.Bold
                    )
                }
                card.type?.let {
                    KapitalText(text = "Type: $it", fontSize = 16, color = Color.Gray)
                }
                card.race?.let {
                    KapitalText(text = "Race: $it", fontSize = 16, color = Color.Gray)
                }
                card.attribute?.let {
                    KapitalText(text = "Attribute: $it", fontSize = 16, color = Color.Gray)
                }
                /*card.frameType?.let {
                    KapitalText(text = "Frame Type: $it", fontSize = 16, color = Color.Gray)
                }*/
                card.desc?.let {
                    KapitalText(text = "Efect: ${it}", fontSize = 16, color = Color.Black)
                }
                /*card.atk?.let {
                    KapitalText(text = "ATK: $it", fontSize = 16, color = Color.Gray)
                }*//*card.def?.let {
                    KapitalText(text = "DEF: $it", fontSize = 16, color = Color.Gray)
                }*//*card.level?.let {
                    KapitalText(text = "Level: $it", fontSize = 16, color = Color.Gray)
                }*/


                /*card.archetype?.let {
                    KapitalText(text = "Archetype: $it", fontSize = 16, color = Color.Gray)
                }*//*card.ygoprodeck_url?.let {
                    KapitalText(text = "URL: $it", fontSize = 16, color = Color.Blue)
                }*/
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCardItemYugioh() {

    MyAppTheme {
        val card = CardData(
            id = 34541863,
            name = "\"A\" Cell Breeding Device",
            type = "Spell Card",
            frameType = "spell",
            desc = "During each of your Standby Phases, put 1 A-Counter on 1 face-up monster your opponent controls.",
            atk = null,
            def = null,
            level = null,
            race = "Continuous",
            attribute = null,
            archetype = null,
            ygoprodeck_url = "https://ygoprodeck.com/card/a-cell-breeding-device-9766",
            card_sets = listOf(
                CardSet(
                    set_name = "Force of the Breaker",
                    set_code = "FOTB-EN043",
                    set_rarity = "Common",
                    set_rarity_code = "(C)",
                    set_price = "0"
                )
            ),
            card_images = listOf(
                CardImage(
                    id = 34541863,
                    image_url = "https://images.ygoprodeck.com/images/cards/34541863.jpg",
                    image_url_small = "https://images.ygoprodeck.com/images/cards_small/34541863.jpg",
                    image_url_cropped = "https://images.ygoprodeck.com/images/cards_cropped/34541863.jpg"
                )
            ),
            card_prices = listOf(
                CardPrice(
                    cardmarket_price = "0.13",
                    tcgplayer_price = "0.16",
                    ebay_price = "0.99",
                    amazon_price = "24.45",
                    coolstuffinc_price = "0.25"
                )
            )
        )
        val navController = rememberNavController()
        CardItemYugioh(card = card, navController = navController)
        //CardItemYugioh(card = card)
    }
}