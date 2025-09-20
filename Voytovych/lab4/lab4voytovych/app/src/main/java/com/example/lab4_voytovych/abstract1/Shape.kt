package com.example.lab4_voytovych.abstract1

abstract class Shape {
    abstract val sides: Int
    abstract fun area(): Double

    open fun describe() {
        println("This shape has $sides sides.")
    }
}

class Square(val side: Double) : Shape() {
    override val sides: Int = 4
    override fun area(): Double = side * side
}