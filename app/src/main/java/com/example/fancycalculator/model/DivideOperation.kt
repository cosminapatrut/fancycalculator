package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation

class DivideOperation(baseValue: Double, secondValue: Double) : BinaryOperation(baseValue, secondValue),
    Operation {

    override fun getResult(): Double {
        var result = 0.0
        if (secondValue != 0.0) {
            result = baseValue / secondValue
        }
        return result
    }
}
