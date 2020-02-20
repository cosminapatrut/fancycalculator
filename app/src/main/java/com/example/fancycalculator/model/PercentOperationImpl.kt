package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.BinaryOperation
import com.example.fancycalculator.model.base.Operation
import com.example.fancycalculator.model.base.SingleOperation

class PercentOperationImpl (
    value: Double) : SingleOperation(
    value), Operation {
    override fun getResult(): Double {

        return value/100
    }
}
