package com.jppedrosa.moovies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jppedrosa.moovies.presentation.navigation.MooviesNavigation
import com.jppedrosa.moovies.ui.base.MooviesAppBaseComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MooviesAppBaseComponent {
                MooviesNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MooviesAppBaseComponent {
        MooviesNavigation()
    }
}