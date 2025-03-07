package com.gonzapolleria.kmp2025.example_ktor_coil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gonzapolleria.kmp2025.example_room.domain.entities.MovieDom
import com.gonzapolleria.kmp2025.shared.BackgroundPrimaryColor
import com.gonzapolleria.kmp2025.shared.DefaultTextColor
import org.koin.compose.viewmodel.koinViewModel
import com.gonzapolleria.kmp2025.shared.components.VideoPlayer
import kmp2025.composeapp.generated.resources.Res
import kmp2025.composeapp.generated.resources.portal
import org.jetbrains.compose.resources.painterResource

@Composable
fun ScreenPrueba(movieDom: MovieDom, onBackPressed: () -> Boolean) {

    val viewModel = koinViewModel<ScreenViewModel>()
    val mediaList by viewModel.state.collectAsState()

    mediaList.respuesta?.let {

        Column {
            val height = if(false) 600.dp else 250.dp
            Box(Modifier.fillMaxWidth().background(BackgroundPrimaryColor)){
                Text("Prueba Parametros NavigationCompose ${movieDom.name}", color = DefaultTextColor)
            }

            ElevatedCard(
                modifier = Modifier.fillMaxWidth().height(height).padding(16.dp)
                    .border(3.dp, Color.Green, CardDefaults.elevatedShape)
            ) {
                Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
                    Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                        VideoPlayer(
                            Modifier.fillMaxWidth().height(200.dp),
                            mediaList.respuesta!!.video
                        )
                    }
                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(Res.drawable.portal),
                            "",
                            modifier = Modifier.padding(8.dp).size(40.dp)
                                .clickable { })
                    }
                }
            }
            AsyncImage(
                model = mediaList.respuesta!!.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }

    }

}