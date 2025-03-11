package com.gonzapolleria.kmp2025.pushnotificactions


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gonzapolleria.kmp2025.shared.components.AppBar

@Composable
fun PushScreen() {
    val screenModel = PushScreenModel()
    val state by screenModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { AppBar(title = "Notifications") },
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = state.title,
                label = { Text("Title") },
                onValueChange = {
                    screenModel.onTitleChange(it)
                }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = state.content,
                label = { Text("Content") },
                onValueChange = {
                    screenModel.onContentChange(it)
                }
            )

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                shape = RectangleShape,
                onClick ={
                    screenModel.sendNotification()
                }
            ) {
                Text("Send notification")
            }
        }
    }
}
