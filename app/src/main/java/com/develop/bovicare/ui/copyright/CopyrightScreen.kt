package com.develop.bovicare.ui.copyright

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun CopyRightText(context: Context) {
    val annotatedString = buildAnnotatedString {
        append("© 2024. Esta aplicación fue desarrollada por los desarrolladores ")
        pushStringAnnotation("link_bryan", "https://github.com/brayanalmengor04")
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
            append("Brayan Almengor")
        }
        pop()
        append(" & ")
        pushStringAnnotation("link_edwin", "https://github.com/Anell-dev/")
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
            append("Edwin González")
        }
        pop()
        append("\n\nPotenciado por ")
        pushStringAnnotation("link_ana", "https://ejemplo.com/ana")
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)) {
            append("Ana Patricia")
        }
        pop()
        append(". Todos los derechos reservados")
    }

    ClickableText(
        text = annotatedString,

        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.let { annotation ->
                openLink(context, annotation.item)
            }
        },
        modifier = Modifier.background(Color(0xFFFCE200)).padding(10.dp),
        style = MaterialTheme.typography.bodySmall.copy(
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    )
}

private fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
