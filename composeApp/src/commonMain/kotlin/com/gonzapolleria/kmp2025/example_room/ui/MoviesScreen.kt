package com.gonzapolleria.kmp2025.example_room.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.gonzapolleria.kmp2025.example_room.data.viewmodels.MovieViewModel
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.navigation.MovieDetail
import com.gonzapolleria.kmp2025.navigation.MyBackHandler
import com.gonzapolleria.kmp2025.navigation.MyCloseApp
import com.gonzapolleria.kmp2025.navigation.Routes
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun MovieScreen(viewModel: MovieViewModel, mainNavController: NavHostController) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showExitDialog by remember { mutableStateOf(false) }

    MyBackHandler(mainNavController){
        showExitDialog = true
    }


    // Diálogo de confirmación para salir de la aplicación
    if (showExitDialog) {
        AlertDialog(
            onDismissRequest = { showExitDialog = false },
            title = { Text("Salir de la aplicación") },
            text = { Text("¿Estás seguro de que quieres salir?") },
            confirmButton = {
                TextButton(onClick = {
                    // Cerrar la aplicación (esto depende de la plataforma)
                    // Aquí puedes llamar a una función específica de plataforma para cerrar la app
                    MyCloseApp()
                }) {
                    Text("Salir")
                }
            },
            dismissButton = {
                TextButton(onClick = { showExitDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }


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
