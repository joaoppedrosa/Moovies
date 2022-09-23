package com.jppedrosa.moovies.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jppedrosa.moovies.R
import com.jppedrosa.moovies.common.utils.ImageUtils
import com.jppedrosa.moovies.data.dto.MovieDto
import com.jppedrosa.moovies.presentation.navigation.Screen
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * @author João Pedro Pedrosa (<a href="mailto:joaopopedrosa@gmail.com">joaopopedrosa@gmail.com</a>) on 22/09/2022.
 */
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(R.color.background_color),
                elevation = 16.dp
            ) {
                Spacer(modifier = Modifier.width(22.dp))
                Text(
                    text = stringResource(R.string.app_name),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
    ) { contentPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    color = colorResource(R.color.background_color)
                )
                .padding(contentPadding)
        ) {

            val state = viewModel.state.value
            MainContent(navController, state.movies)
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<MovieDto>
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(moviesList) { movie ->
                MovieRow(movie = movie) { movieId ->
                    navController.navigate(route = Screen.DetailsScreen.route + "/$movieId")
                }
            }
        }
    }
}

@Composable
fun MovieRow(
    movie: MovieDto,
    onItemClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(6.dp)
            .background(
                color = Color.Transparent
            )
            .clickable {
                onItemClick(movie.id.toString())
            }
    ) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(140.dp)
                .align(alignment = Alignment.BottomStart),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 6.dp,
            backgroundColor = colorResource(R.color.card_background_color)
        ) {
            Row(
                modifier = Modifier
                    .height(140.dp)
                    .padding(6.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(120.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = movie.title!!,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = movie.releaseDate!!,
                        color = colorResource(R.color.gray_text_color),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = movie.popularity.toString(),
                        color = colorResource(R.color.gray_text_color),
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .height(160.dp)
                .width(100.dp)
                .offset(x = 16.dp, y = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            GlideImage(
                previewPlaceholder = R.drawable.ic_launcher_background,
                modifier = Modifier.border(0.dp, Color.Transparent, RoundedCornerShape(16.dp)),
                imageModel = ImageUtils.getTmdbUrlImage(movie.posterPath!!),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.BottomCenter
                )
            )
        }
    }
}