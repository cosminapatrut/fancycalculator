package com.example.fancycalculator.model

enum class OperationType(
    val key: String
) {
    PLUS("plus"),
    MINUS("minus"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    DIGIT("digit"),
    EQUALS("equals"),
    ROOT("root"),
    POWER("power"),
    PERCENT("%")
}
