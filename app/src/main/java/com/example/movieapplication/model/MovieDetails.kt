package com.example.movieapplication.model

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieRow(modifier: Modifier = Modifier, movie: Movie) {
    val context = LocalContext.current
    val images = context.resources.getStringArray(movie.images)[0]
    var expanded by remember { mutableStateOf(false) }

    Row(modifier.padding(8.dp)) {
        Surface(
            modifier = modifier
                .size(120.dp)
                .padding(4.dp),
            shape = RectangleShape
        ) {
            AsyncImage(
                modifier = modifier.clip(shape = RectangleShape),
                contentScale = ContentScale.Crop,
                model = images,
                contentDescription = null
            )
        }
        Column(modifier.padding(start = 8.dp)) {
            Text(
                stringResource(id = movie.title),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                modifier = modifier.padding(top = 8.dp)
            )
            Text(buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Director : ")
                }
                withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(stringResource(id = movie.director))
                }
            })
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Released : ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(stringResource(movie.year))
                }
            })

            AnimatedVisibility(visible = expanded) {
                Column(modifier = modifier.padding(top = 6.dp)) {
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Plot : ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                            append(stringResource(movie.plot))
                        }
                    })
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Actors : ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                            append(stringResource(movie.actors))
                        }
                    })
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Rating : ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                            append(stringResource(movie.rating))
                        }
                    })
                }
            }
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = modifier.clickable { expanded = !expanded }
            )
        }
    }
}