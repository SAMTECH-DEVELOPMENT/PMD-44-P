package com.example.lab4_voytovych.delegation

import com.example.lab4_voytovych.interface1.Printer
import com.example.lab4_voytovych.interface1.Scanner

class Device : Printer by PrinterImpl(), Scanner by ScannerImpl()

class PrinterImpl : Printer {
    override fun print(message: String) {
        println("Print: $message")
    }
}

class ScannerImpl : Scanner {
    override fun scan(): String = "Scanned data"
}