package ua.saceit.lab3_nestor

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
import ua.saceit.lab3_nestor.ui.theme.Lab3NestorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3NestorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d("MainActivity", "Sum > 10: ${add(5, 3)}")
        Log.d("MainActivity", greet())
        Log.d("MainActivity", greet("John"))
    }
}

fun add(a: Int, b: Int): Boolean {
    return (a + b) > 10
}

fun greet(name: String = "Guest"): String {
    return "Привіт, $name!"
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    val sumResult = add(5, 3)
    val greetResult = greet()
    val greetJohn = greet("Vasyl Kit")

    Text(
        text = "Сума 5 + 6 > 10? $sumResult\n" +
                "Привітання: $greetResult\n" +
                "Привітання: $greetJohn",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab3NestorTheme {
        GreetingScreen()
    }
}