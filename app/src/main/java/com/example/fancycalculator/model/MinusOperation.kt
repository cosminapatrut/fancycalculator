package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation


class MinusOperation(baseValue: Double, secondValue: Double) : BinaryOperation(baseValue, secondValue),
    Operation {

    override fun getResult() = baseValue - secondValue
}
