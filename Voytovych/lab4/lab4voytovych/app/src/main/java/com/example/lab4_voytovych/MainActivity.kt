package com.example.lab4_voytovych

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
import com.example.lab4_voytovych.delegation.Device
import com.example.lab4_voytovych.data.Student
import com.example.lab4_voytovych.model.Animal
import com.example.lab4_voytovych.model.Car
import com.example.lab4_voytovych.model.Person
import com.example.lab4_voytovych.model.Vehicle
import com.example.lab4_voytovych.abstract1.Square
import com.example.lab4_voytovych.ui.theme.Lab4VoytovychTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4VoytovychTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val myAnimal = Animal()
    myAnimal.name = "Buddy"
    myAnimal.age = 3
    myAnimal.makeSound()
    myAnimal.introduce()

    val myCar = Car()
    myCar.start()

    val person1 = Person("Voytovych", "Doe", 25)
    person1.introduce()

    val vehicle = Vehicle("mercedes", 2023)
    vehicle.startEngine()
    vehicle.stopEngine()


    val student = Student(1, "Roman", 75.5)
    val passed = student.pass()

    val device = Device()
    val scanResult = device.scan()
    device.print("Hello from device!")

    val square = Square(5.0)
    val area = square.area()
    square.describe()

    Text(
        text = """
            Animal: ${myAnimal.name}, age: ${myAnimal.age}
            Car year: ${myCar.year}, color: ${myCar.color}
            Person: ${person1.firstName} ${person1.lastName}, age: ${person1.age}
            Vehicle: ${vehicle.brand}, year: ${vehicle.year}
            Student: ${student.name}, grade: ${student.grade}, passed: $passed
            Device scan: $scanResult
            Square area: $area
        """.trimIndent(),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab4VoytovychTheme {
        Greeting()
    }
}