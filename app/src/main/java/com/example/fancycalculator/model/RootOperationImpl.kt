package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.Operation
import com.example.fancycalculator.model.base.SingleOperation
import kotlin.math.sqrt

class RootOperationImpl (
        value: Double
) : SingleOperation(
value
), Operation {
    override fun getResult() = sqrt(value)
}



