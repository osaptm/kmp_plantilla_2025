import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    //ROOM
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)

    //Ktor para consumo de APIS Serializacion
    alias(libs.plugins.kotlinxSerialization)

    //LOGIN GOOGLE // FIREBASE Y NOTIFICACIONES
    id("com.google.gms.google-services")

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            export("io.github.mirzemehdi:kmpnotifier:1.4.0")
            baseName = "ComposeApp"
            isStatic = true
        }
    }



    sourceSets {
        task("testClasses")
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            //KOIN
            implementation(libs.koin.android)
            //Ktor para consumo de APIS
            implementation(libs.ktor.client.okhttp)
            //Splash Screen
            implementation(libs.core.splashscreen)
            //LOGIN GOOGLE
            implementation(libs.androidx.credentials)
            implementation(libs.androidx.credentials.play.services.auth)
            implementation(libs.googleid)

            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:33.10.0"))
            implementation(libs.firebase.auth.ktx)

            // PARA FUNCIONAR NOTIFICACIONES PUSH
            implementation("androidx.startup:startup-runtime:1.2.0")

        }
        val commonMain by getting {
            dependencies {

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)

                //NAVIGATION COMPOSE
                implementation(libs.navigation.compose)
                //ROOM y KOIN
                implementation(libs.androidx.room.runtime)
                implementation(libs.sqlite.bundled)
                api(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)
                //Ktor para consumo de APIS
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.kotlin.serialization)
                //Coil para cargar Imagenes de URL
                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor3)
                //WEBVIEW PARA VIDEOS
                api(libs.compose.webview.multiplatform)

                //NOTIFICACIONES PUSH
                api("io.github.mirzemehdi:kmpnotifier:1.4.0")

            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }


    }

}

android {
    namespace = "com.gonzapolleria.kmp2025"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gonzapolleria.kmp2025"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.ui.android)
    implementation(libs.androidx.ui.graphics.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.text.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.annotation.jvm)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.runtime.saveable.android)
    debugImplementation(compose.uiTooling)
    //ROOM KSP
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosX64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
