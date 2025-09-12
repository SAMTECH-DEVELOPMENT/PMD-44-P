package com.example.lab2_collegehub_voytovych

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2_collegehub_voytovych.ui.theme.Lab2CollegehubVoytovychTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val x: Double = 6.4
        val z: Double = sqrt(x) - (x / (x + 1)) + (0.2 * x)

        Log.d("MainActivity", "x = $x")
        Log.d("MainActivity", "z = $z")


        for (i in 1..5) {
            Log.d("MainActivity", "Number: $i")
        }

        setContent {
            Lab2CollegehubVoytovychTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        text = "Група: 44п\nСтудент: Войтович Роман\n" +
                                "x = $x\n" +
                                "z = $z",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}

