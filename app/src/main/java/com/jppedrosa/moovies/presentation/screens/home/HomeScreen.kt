package com.jppedrosa.moovies.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jppedrosa.moovies.R
import com.jppedrosa.moovies.presentation.navigation.Screen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                elevation = 5.dp
            ) {
                Text(text = "Moovies", color = Color.White)
            }
        },
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            MainContent(navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf("Avatar", "Harry Potter", "300")
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviesList) {
                MovieRow(navController = navController, movie = it) { movie ->
                    navController.navigate(route = Screen.DetailsScreen.route)
                }
            }
        }
    }
}

@Composable
fun MovieRow(
    navController: NavController,
    movie: String,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                GlideImage(
                    previewPlaceholder = R.drawable.ic_launcher_background,
                    imageModel = "https://upload.wikimedia.org/wikipedia/pt/3/3a/Interstellar_Filme.png",
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )
            }
            Text(text = movie)
        }
    }
}