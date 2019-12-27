package com.example.fancycalculator.presenter

import com.example.fancycalculator.R
import com.example.fancycalculator.model.*

interface CalculatorListeners {

    fun resetValueIfNeeded()
    fun resetValues()
    fun setValue(value: String)
    fun setFormula(value: String)
    fun updateFormula()
    fun addDigit(number: Int)
    fun formatString(str: String): String
    fun updateResult(value: Double)
    fun getDisplayedNumberAsDouble()
    fun handleResult()
    fun handleRoot()
    fun handleFactorial()
    fun calculateResult()
    fun handleOperation(operation: String)
    fun handleClear()
    fun handleReset()
    fun handleEquals()
    fun decimalClicked()
    fun zeroClicked()
    fun getSign(lastOperation: String?)
    fun numpadClicked(id: Int)
}