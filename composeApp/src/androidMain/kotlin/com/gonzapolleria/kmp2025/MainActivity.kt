package com.gonzapolleria.kmp2025

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mmk.kmpnotifier.permission.AndroidPermissionUtil
import com.mmk.kmpnotifier.permission.permissionUtil

@SuppressLint("StaticFieldLeak")
object ActivityContextProvider {
    lateinit var context: Context
        private set
    fun init(context: Context) {
        this.context = context
    }
}
class MainActivity : ComponentActivity() {
    //Para permisos de notificaciones
    val permissionUtil: AndroidPermissionUtil by permissionUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar el contexto activity
        ActivityContextProvider.init(this)
        installSplashScreen()
        setContent {
            App()
        }
    }

    //pedir permisos de notificaciones al inicial app
    override fun onStart() {
        super.onStart()
        permissionUtil.askNotificationPermission { isSuccess ->
            if (isSuccess) return@askNotificationPermission
            Toast.makeText(this, "Permissions is required", Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}