package com.gonzapolleria.kmp2025.login.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzapolleria.kmp2025.login.GoogleAuthClient
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(){
    val googleAuthClient = GoogleAuthClient()
    var isSignIn = rememberSaveable { mutableStateOf(googleAuthClient.isSingedIn()) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        if (isSignIn.value) {

            OutlinedButton(onClick = {
                coroutineScope.launch {
                    googleAuthClient.signOut()
                    isSignIn.value = false
                }
            }) {
                Text(
                    text = "Sign Out",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(
                        horizontal = 24.dp, vertical = 4.dp
                    )
                )
            }

        } else {

            OutlinedButton(onClick = {
                coroutineScope.launch {
                    isSignIn.value = googleAuthClient.signIn()
                }
            }) {
                Text(
                    text = "Sign In With Google",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(
                        horizontal = 24.dp, vertical = 4.dp
                    )
                )
            }

        }
    }
}
