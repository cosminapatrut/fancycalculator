package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation

class DivideOperationImpl(
    firstValue: Double,
    secondValue: Double
) : BinaryOperation(
    firstValue,
    secondValue
), Operation {

    override fun getResult(): Double {
        var result = 0.0
        if (secondValue != 0.0) {
            result = firstValue / secondValue
        }
        return result
    }
}
