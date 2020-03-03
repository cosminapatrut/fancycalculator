package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation

class PowerOperationImpl(
firstValue: Double,
secondValue: Double
) : BinaryOperation(
firstValue,
secondValue), Operation {
    override fun getResult(): Double {
        var result = Math.pow(firstValue, secondValue)
        if (result.isInfinite() || result.isNaN())
            result = 0.0
        return result
    }
}