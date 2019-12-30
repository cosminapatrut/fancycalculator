package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation

class PlusOperation(firstValue: Double, secondValue: Double) : BinaryOperation(firstValue, secondValue),
    Operation {

    override fun getResult() = firstValue + secondValue
}
