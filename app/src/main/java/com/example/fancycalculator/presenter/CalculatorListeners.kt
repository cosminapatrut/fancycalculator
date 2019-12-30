package com.example.fancycalculator.presenter

interface CalculatorListeners {

    fun resetValueIfNeeded()
    fun setValue(value: String)
    fun setFormula(value: String)
    fun updateFormula()
    fun addDigit(number: Int)
    fun formatString(str: String): String
    fun updateResult(value: Double)
    fun handleResult()
    fun calculateResult()
    fun handleOperation(operation: String)
    fun handleDelete()
    fun handleReset()
    fun handleEquals()
    fun handleDot()
    fun zeroClicked()
    fun getSign(lastOperation: String?): String
    fun numberClicked(id: Int)
}