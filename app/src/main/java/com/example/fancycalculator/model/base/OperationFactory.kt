package com.example.fancycalculator.model.base

interface OperationFactory {
    fun forId(id: String, firstValue: Double, secondValue: Double): Operation?
}
