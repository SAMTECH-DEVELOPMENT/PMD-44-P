package com.example.lab4_voytovych.data

data class Student(
    val id: Int,
    val name: String,
    val grade: Double
) {
    fun pass(): Boolean = grade >= 60.0
}


