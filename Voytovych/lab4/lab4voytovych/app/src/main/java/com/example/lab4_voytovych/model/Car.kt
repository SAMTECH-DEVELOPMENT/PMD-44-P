package com.example.lab4_voytovych.model

class Car {
    private var engine: String = "V8"
    internal var color: String = "Red"
    var year: Int = 2024

    fun start() {
        println("Starting $engine engine...")
    }
}


