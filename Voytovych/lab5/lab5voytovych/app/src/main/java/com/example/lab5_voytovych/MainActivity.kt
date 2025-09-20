package com.example.lab5_voytovych

import android.os.Bundle
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
import com.example.lab5_voytovych.ui.theme.Lab5voytovychTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5voytovychTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StringListScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StringListScreen(modifier: Modifier = Modifier) {
    val upperProcessor = Upper()

    val originalStrings = upperProcessor.getOriginalStrings()

    val upperCaseStrings = upperProcessor.transformToUpperCase()

    upperProcessor.setOriginalStrings(listOf("new", "strings", "here"))

    val newOriginalStrings = upperProcessor.getOriginalStrings()
    val newUpperCaseStrings = upperProcessor.transformToUpperCase()

    Text(
        text = """
            Оригінальні строки:
            ${originalStrings.joinToString(", ")}
            
            Верхній регістр:
            ${upperCaseStrings.joinToString(", ")}
            
            Після зміни (сетер):
            ${newOriginalStrings.joinToString(", ")}
            
            Новий верхній регістр:
            ${newUpperCaseStrings.joinToString(", ")}
        """.trimIndent(),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun StringListPreview() {
    Lab5voytovychTheme {
        StringListScreen()
    }
}