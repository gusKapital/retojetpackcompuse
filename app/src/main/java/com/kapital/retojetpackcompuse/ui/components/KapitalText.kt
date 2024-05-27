package com.kapital.retojetpackcompuse.ui.components


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.kapital.retojetpackcompuse.R

/***
 * Componente para titulos
 * backgroundColor: Color de fondo del texto.
 * textColor: Color del texto.
 * fontWeight: Peso de la fuente (negrita, normal, etc.).
 * textDecoration: Decoraciones del texto como subrayado y tachado.
 * textStyle: Estilo del texto para configuraciones adicionales.
 * shape: Forma del fondo (curvatura).
 * */
@Composable
fun KapitalTitleText(
    text: String,
    fontSize: TextUnit = 24.sp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    fontWeight: FontWeight = FontWeight.Bold,
    textDecoration: TextDecoration? = null,
    textStyle: TextStyle = TextStyle.Default,
    shape: Shape = RectangleShape,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
            .padding(8.dp),
        style = textStyle.copy(
            fontSize = fontSize,
            color = textColor,
            fontWeight = fontWeight,
            textDecoration = textDecoration
        )
    )
}

@Composable
fun KapitalText(
    text: String,
    fontSize: TextUnit = 16.sp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    fontWeight: FontWeight = FontWeight.Normal,
    textDecoration: TextDecoration? = null,
    textStyle: TextStyle = TextStyle.Default,
    shape: Shape = RectangleShape,
    icon: Int? = null,  // Resource ID of the icon
    iconPosition: IconPosition = IconPosition.Start,
    textType: TextType = TextType.Normal,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null  // For clickable text
) {
    Row(
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
            .padding(8.dp)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
    ) {
        if (icon != null && iconPosition == IconPosition.Start) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        Text(
            text = text,
            style = textStyle.copy(
                fontSize = fontSize,
                color = textColor,
                fontWeight = fontWeight,
                textDecoration = textDecoration
            )
        )

        if (icon != null && iconPosition == IconPosition.End) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = textColor,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

enum class IconPosition {
    Start, End
}

enum class TextType {
    Normal, Link
}

@Composable
fun KapitalText(text: String= "", fontSize: Int = 16, color: Color = MaterialTheme.colorScheme.onBackground, fontWeight: FontWeight = FontWeight.Normal) {
    BasicText(text = text, style = TextStyle(fontSize = fontSize.sp, color = color, fontWeight = fontWeight))
}

/*@Composable
fun BodyText(
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = 16.sp,
    style: TextStyle = MaterialTheme.typography.bodySmall
) {
    BasicText(
        text = text,
        style = style.copy(
            fontSize = fontSize,
            color = color
        )
    )
}

@Composable
fun CaptionText(
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = 12.sp,
    style: TextStyle = MaterialTheme.typography.headlineLarge
) {
    BasicText(
        text = text,
        style = style.copy(
            fontSize = fontSize,
            color = color
        )
    )
}*/


@Preview(showBackground = true)
@Composable
fun PreviewKapitalText() {
    MaterialTheme {
        Column {
            KapitalText(
                text = "Primary Title",
                fontSize = 20.sp,
                textColor = Color.White,
                backgroundColor = Color.Cyan,
                fontWeight = FontWeight.Bold,
                shape = RoundedCornerShape(8.dp),
                textDecoration = TextDecoration.Underline,
                textStyle = TextStyle.Default,
                icon = R.drawable.ic_launcher_foreground,  // Replace with actual icon resource ID
                iconPosition = IconPosition.Start,
                textType = TextType.Normal,
                onClick = { /* Handle click */ }
            )
            KapitalText(
                text = "Secondary Title",
                fontSize = 16.sp,
                textColor = Color.Blue,
                backgroundColor = Color.Transparent,
                fontWeight = FontWeight.SemiBold,
                shape = RectangleShape,
                textDecoration = TextDecoration.LineThrough,
                textStyle = TextStyle.Default,
                icon = R.drawable.ic_launcher_foreground,  // Replace with actual icon resource ID
                iconPosition = IconPosition.End,
                textType = TextType.Link,
                onClick = { /* Handle click */ }
            )
        }
    }
}