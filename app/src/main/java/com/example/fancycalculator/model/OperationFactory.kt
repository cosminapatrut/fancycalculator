package com.example.fancycalculator.model

import com.example.fancycalculator.model.base.Operation

interface OperationFactory {
    fun forId(id: String, baseValue: Double, secondValue: Double): Operation?
}
