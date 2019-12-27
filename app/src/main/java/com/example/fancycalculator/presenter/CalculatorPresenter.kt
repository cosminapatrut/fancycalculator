package com.example.fancycalculator.presenter


import android.content.Context
import com.example.fancycalculator.R
import com.example.fancycalculator.model.*
import com.example.fancycalculator.view.Calculator

class CalculatorPresenter(operation: OperationImpl, calculator: Calculator, val context: Context) : CalculatorListeners{
    override fun resetValueIfNeeded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resetValues() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFormula(value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateFormula() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDigit(number: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun formatString(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateResult(value: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayedNumberAsDouble() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleRoot() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleFactorial() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun calculateResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleOperation(operation: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleClear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleReset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleEquals() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun decimalClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun zeroClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSign(lastOperation: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun numpadClicked(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
