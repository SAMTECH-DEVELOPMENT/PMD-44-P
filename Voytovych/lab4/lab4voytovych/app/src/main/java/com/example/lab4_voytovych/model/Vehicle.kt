package com.example.lab4_voytovych.model

open class Vehicle(val brand: String, val year: Int) {
    open fun startEngine() {
        println("${brand} engine started.")
    }

    fun stopEngine() {
        println("${brand} engine stopped.")
    }
}




