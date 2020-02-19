package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation

class PlusOperationImpl(
    firstValue: Double,
    secondValue: Double
) : BinaryOperation(
    firstValue,
    secondValue
), Operation {
    override fun getResult(): Double = firstValue + secondValue
}
