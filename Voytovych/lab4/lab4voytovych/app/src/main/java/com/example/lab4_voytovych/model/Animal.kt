package com.example.lab4_voytovych.model
class Animal {
    var name: String = ""
    var age: Int = 0

    fun makeSound() {
        println("Some sound")
    }

    fun introduce() {
        println("Hi, I'm $name and I'm $age years old.")
    }
}