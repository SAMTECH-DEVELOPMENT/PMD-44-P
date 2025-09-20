package com.example.lab4_voytovych.model

class Person(
    val firstName: String,
    val lastName: String,
    var age: Int = 0
) {

    fun introduce() {
        println("Hello, I'm $firstName $lastName, ${if (age > 0) "$age years old"
        else "unknown age"}")
    }
}



