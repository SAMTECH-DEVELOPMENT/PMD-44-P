package com.example.lab5_voytovych

class Upper {
    private var _originalStrings: List<String> = listOf("hello", "world", "kotlin", "android",
        "lab5")

    fun getOriginalStrings(): List<String> {
        return _originalStrings
    }

    fun setOriginalStrings(strings: List<String>) {
        _originalStrings = strings
    }

    fun transformToUpperCase(): List<String> {
        return _originalStrings.map { it.uppercase() }
    }
}