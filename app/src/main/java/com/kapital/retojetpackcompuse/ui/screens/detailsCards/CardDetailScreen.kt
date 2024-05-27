package com.kapital.retojetpackcompuse.ui.screens.detailsCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.kapital.retojetpackcompuse.domain.model.CardData
import com.kapital.retojetpackcompuse.domain.model.CardImage
import com.kapital.retojetpackcompuse.domain.model.CardPrice
import com.kapital.retojetpackcompuse.domain.model.CardSet
import com.kapital.retojetpackcompuse.ui.components.KapitalText
import com.kapital.retojetpackcompuse.ui.components.KapitalTitleText
import com.kapital.retojetpackcompuse.ui.components.TextType

@Composable
fun CardDetailScreen(card: CardData) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val painter: Painter = rememberAsyncImagePainter(model = card.card_images.first().image_url)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        card.name?.let {
            KapitalTitleText(
                text = "Mame ${it}" ,
                fontSize = 20.sp,
                textColor = Color.Black,
                fontWeight = FontWeight.Bold
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
        card.frameType?.let {
            KapitalText(text = "Frame Type: $it", fontSize = 16, color = Color.Gray)
        }
        card.desc?.let {
            KapitalText(text = "Efect: ${it}", fontSize = 16, color = Color.Black)
        }
        card.atk?.let {
            KapitalText(text = "ATK: $it", fontSize = 16, color = Color.Gray)
        }
        card.def?.let {
            KapitalText(text = "DEF: $it", fontSize = 16, color = Color.Gray)
        }
        card.level?.let {
            KapitalText(text = "Level: $it", fontSize = 16, color = Color.Gray)
        }

        card.archetype?.let {
            KapitalText(text = "Archetype: $it", fontSize = 16, color = Color.Gray)
        }
        card.ygoprodeck_url?.let {
            KapitalText(text = "URL: $it", fontSize = 16, color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardDetailScreen() {
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
        ygoprodeck_url = "https://ygoprodeck.com/card/a-cell-breeding-device-9766",
        archetype = "nomo",
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

    MaterialTheme {
        CardDetailScreen(card = card)
    }
}