package com.example.fancycalculator.presenter


import android.content.Context
import com.example.fancycalculator.R
import com.example.fancycalculator.model.*
import com.example.fancycalculator.model.Formatter
import com.example.fancycalculator.view.Calculator
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class CalculatorPresenter(operation: OperationImpl, calculator: Calculator) : CalculatorListeners{
    var displayedNumber: String
    lateinit  var displayedFormula: String
    var lastKey: String? = null
    private var history: String? = null
    private var calculator: Calculator? = calculator

    private var isFirstOperation = false
    private var resetValue = false
    private var wasPercentLast = false
    private var firstValue = 0.0
    private var secondValue: Double = 0.0
    private var operation: OperationImpl = operation

    init {
        displayedNumber = ""
        setValue("")
        setFormula("")
    }

    override fun handleOperation(operation: String) {
        if (lastKey == DIGIT) {
            handleResult()
        }

        resetValue = true
        lastKey = operation
        history = operation

    }

    override fun resetValueIfNeeded() {
        if (resetValue)
            displayedNumber = "0"

        resetValue = false
    }

    override fun setValue(value: String) {
        if(calculator != null)
        {
            calculator?.setValue(value)
        }
        displayedNumber = value
    }

    override fun setFormula(value: String) {
        calculator?.setFormula(value)
        displayedFormula = value
    }

    override fun updateFormula() {
        val first = Formatter.doubleToString(firstValue)
        val second = Formatter.doubleToString(secondValue)
        val sign = getSign(history)

            if (!sign.isEmpty()) {
            var formula = first + sign + second
            if (wasPercentLast) {
                formula += "%"
            }
            setFormula(formula)
        }
    }

    override fun addDigit(number: Int) {
        val currentValue = displayedNumber
        val newValue = formatString(currentValue + number)
        setValue(newValue)
    }

    override fun formatString(str: String): String {
        if (str.contains(".")) {
            return str
        }

        val doubleValue = Formatter.stringToDouble(str)
        return Formatter.doubleToString(doubleValue)
    }

    override fun updateResult(value: Double) {
        val symbols = DecimalFormatSymbols(Locale.US)
        symbols.decimalSeparator = '.'
        symbols.groupingSeparator = ','

        val formatter = DecimalFormat()
        formatter.maximumFractionDigits = 12
        formatter.decimalFormatSymbols = symbols
        formatter.isGroupingUsed = true

        setValue(formatter.format(value))

        firstValue = value
    }

    override fun handleResult() {
        displayedNumber.let {
            secondValue = it.replace(",", "").toDouble()
        }
        calculateResult()
        displayedNumber.let {
            firstValue = it.replace(",", "").toDouble()
        }
    }

    override fun calculateResult() {
        updateFormula()

        val operationResult = history?.let { operation.forId(it, firstValue, secondValue) }
        if (operationResult != null) {
            updateResult(operationResult.getResult())
        }

        isFirstOperation = false
    }

    override fun handleDelete() {
        if (displayedNumber.equals(NAN)) {
            handleReset()
        } else {
            val oldValue = displayedNumber
            var newValue = "0"
            val len = oldValue.length
            var minLen = 1
            if (oldValue.contains("-"))
                minLen++

            if (len > minLen) {
                newValue = oldValue.substring(0, len - 1)
            }

            newValue = newValue.replace("\\.$".toRegex(), "")
            newValue = formatString(newValue)
            setValue(newValue)
            firstValue = Formatter.stringToDouble(newValue)
        }
    }

    override fun handleReset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleEquals() {
        if (lastKey == EQUALS)
            calculateResult()

        if (lastKey != DIGIT)
            return

        displayedNumber.let {
            secondValue = it.replace(",", "").toDouble()
        }
        calculateResult()
        lastKey = EQUALS
    }

    override fun handleDot() {
        var value = displayedNumber
        if (!value.contains(".")) {
            value += "."
        }
        setValue(value)
    }

    override fun zeroClicked() {
        val value = displayedNumber
        if (value != "0") {
            addDigit(0)
        }
    }

    override fun getSign(lastOperation: String?) = when (lastOperation) {
        PLUS -> "+"
        MINUS -> "-"
        MULTIPLY -> "*"
        DIVIDE -> "/"
        PERCENT -> "%"
        POWER -> "^"
        ROOT -> "√"
        FACTORIAL -> "!"
        else -> ""
    }

    override fun numberClicked(id: Int) {
        if (lastKey == EQUALS) {
            history = EQUALS
        }

        lastKey = DIGIT
        resetValueIfNeeded()

        when (id) {
            R.id.button_zero -> zeroClicked()
            R.id.button_one -> addDigit(1)
            R.id.button_two -> addDigit(2)
            R.id.button_three -> addDigit(3)
            R.id.button_four -> addDigit(4)
            R.id.button_five -> addDigit(5)
            R.id.button_six -> addDigit(6)
            R.id.button_seven -> addDigit(7)
            R.id.button_eight -> addDigit(8)
            R.id.button_nine -> addDigit(9)
        }
    }

}
