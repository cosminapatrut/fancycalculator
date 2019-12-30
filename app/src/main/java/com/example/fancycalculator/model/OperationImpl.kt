package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.Operation

class OperationImpl : OperationFactory {
    override fun forId(id: String, firstValue: Double, secondValue: Double): Operation? {
        return when (id) {
            PLUS -> PlusOperation(firstValue, secondValue)
            MINUS -> MinusOperation(firstValue, secondValue)
            DIVIDE -> DivideOperation(firstValue, secondValue)
            MULTIPLY -> MultiplyOperation(firstValue, secondValue)
//            PERCENT -> PercentOperation(baseValue, secondValue)
//            POWER -> PowerOperation(baseValue, secondValue)
//            ROOT -> RootOperation(baseValue)
//            FACTORIAL -> FactorialOperation(baseValue)
            else -> null
        }
    }




}