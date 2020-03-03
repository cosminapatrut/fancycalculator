package com.example.fancycalculator.model
import com.example.fancycalculator.model.OperationType.*
import com.example.fancycalculator.model.base.Operation
import com.example.fancycalculator.model.base.OperationFactory

class OperationFactoryImpl: OperationFactory {
    override fun forId(id: String, firstValue: Double, secondValue: Double): Operation? {
        return when (id) {
            PLUS.key -> PlusOperationImpl(firstValue, secondValue)
            MINUS.key -> MinusOperationImpl(firstValue, secondValue)
            DIVIDE.key -> DivideOperationImpl(firstValue, secondValue)
            MULTIPLY.key -> MultiplyOperationImpl(firstValue, secondValue)
            else -> null
        }
    }
}