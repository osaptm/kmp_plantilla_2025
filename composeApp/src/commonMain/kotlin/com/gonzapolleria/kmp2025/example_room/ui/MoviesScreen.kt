package com.gonzapolleria.kmp2025.example_room.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gonzapolleria.kmp2025.example_room.data.viewmodels.MovieViewModel
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.navigation.MovieDetail
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel, mainNavController: NavHostController) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MovieScreen(
        movies = uiState.movies,
        movieName = uiState.movieName,
        onUpdateMovieName = viewModel::updateMovieName,
        onAddMovie = viewModel::insertMovie,
        onDeleteMovies = viewModel::deleteMovies,
        mainNavController =  mainNavController
    )
}

@Composable
fun MovieScreen(
    movies: List<MovieDom>,
    movieName: TextFieldValue,
    onUpdateMovieName: (TextFieldValue) -> Unit,
    onAddMovie: (String) -> Unit,
    onDeleteMovies: () -> Unit,
    mainNavController: NavHostController
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { scaffoldPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(scaffoldPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = movieName,
                onValueChange = { onUpdateMovieName(it) },
                label = { Text(text = "Enter movie name") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (movieName.text.isNotBlank()) {
                        onAddMovie(movieName.text)
                        onUpdateMovieName(TextFieldValue(""))
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Add Movie")
            }

            Button(
                onClick = onDeleteMovies,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Delete movies")
            }



            LazyColumn(modifier = Modifier.weight(1f)) {
                items(movies) { movie ->
                    MovieItem(movie){
                        val encode: String = Json.encodeToString(movie)
                        mainNavController.navigate(MovieDetail(encode))
                    }
                }
            }

        }
    }
}

@Composable
fun MovieItem(
    movie: MovieDom,
    modifier: Modifier = Modifier,
    navigatePrueba : (MovieDom) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp).clickable {
                navigatePrueba(movie)
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = movie.name,
            modifier = Modifier.padding(16.dp)
        )
    }
}
