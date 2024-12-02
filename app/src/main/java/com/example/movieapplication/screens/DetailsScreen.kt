package com.example.movieapplication.screens

import android.telecom.Call.Details
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapplication.R
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.MovieRow
import com.example.movieapplication.model.movieList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavController, movieId: Int?) {
    val movieFilterList = movieList.filter { movie -> movie.id == movieId }

    Column(modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier
                            .clickable { navController.popBackStack() }
                            .size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(108.dp))
                    Text(
                        stringResource(R.string.movies)
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
        )
        MovieRow(movie = movieFilterList.first())

        Divider(thickness = 2.dp)

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(R.string.movie_images),
                fontWeight = FontWeight.Bold
            )
        }
        MovieLazyRow(movieList = movieFilterList)
    }
}

@Composable
fun MovieLazyRow(movieList: List<Movie>, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    movieList.forEach { movie ->
        LazyRow(modifier.padding(top = 8.dp)) {
            items(context.resources.getStringArray(movie.images)) { imagesUrl ->
                Card(
                    modifier
                        .size(160.dp)
                        .padding(4.dp)) {
                    AsyncImage(
                        model = imagesUrl,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}
