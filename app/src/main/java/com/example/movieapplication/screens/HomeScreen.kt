package com.example.movieapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapplication.R
import com.example.movieapplication.model.MovieRow
import com.example.movieapplication.model.movieList
import com.example.movieapplication.navigation.MovieScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue),
                title = { Text(text = stringResource(id = R.string.movies)) }
            )
        }) { paddingValues ->
        LazyColumn(modifier.padding(paddingValues)) {
            items(movieList) { movie ->
                Card(
                    modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .shadow(elevation = 8.dp)
                        .clickable { navController.navigate("${MovieScreen.DetailsScreen.route}/${movie.id}") },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    MovieRow(movie = movie)
                }
            }
        }
    }
}


