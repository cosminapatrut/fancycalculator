package com.example.fancycalculator.presenter


import android.net.wifi.aware.WifiAwareSession
import com.example.fancycalculator.model.*
import com.example.fancycalculator.view.Calculator
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import com.example.fancycalculator.model.OperationType.*

class CalculatorPresenterImpl(private var operation: OperationFactoryImpl, calculator: Calculator) : CalculatorPresenter {
    private var history: String? = null
    private var calculator: Calculator? = calculator
    private var isFirstOperation = false
    private var resetValue = false
    private var firstValue = 0.0
    private var secondValue: Double = 0.0
    private var displayedNumber: String
    private var lastKey: String? = null
    lateinit var displayedFormula: String

    init {
        displayedNumber = ""
        setValue("")
        setFormula("")
    }

    override fun handleOperation(operation: String) {
        if (lastKey == DIGIT.key &&
                operation != ROOT.key) {
            handleResult()
        }

        resetValue = true
        lastKey = operation
        history = operation

        if(operation == ROOT.key){
            handleRoot()
            resetValue = false
        }

        if(operation == PERCENT.key) {
            handlePercent()
            resetValue = false
        }
    }

    override fun resetValueIfNeeded() {
        if (resetValue) {
            displayedNumber = "0"
        }
        resetValue = false
    }

    override fun setValue(value: String) {
        if (calculator != null) {
            calculator?.setValue(value)
        }
        displayedNumber = value
    }

    override fun setFormula(value: String) {
        calculator?.setFormula(value)
        displayedFormula = value
    }

    override fun updateFormula() {
        val first = firstValue.doubleToString()
        val second = secondValue.doubleToString()
        val sign = getSign(history)

        when(sign) {
            "√" -> {
                setFormula(sign + first)
            }
            "%" -> {
                setFormula(first + sign)
            }
            else -> {
                if (sign.isNotEmpty()){
                    var formula = first + sign + second
                    setFormula(formula)
                }
            }
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
        val doubleValue = str.stringToDouble()
        return doubleValue.doubleToString()
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
            firstValue = it.replace(",", "").toDouble()
        }
        calculateResult()
        displayedNumber.let {
            secondValue = it.replace(",", "").toDouble()
        }
    }

    override fun calculateResult() {
        updateFormula()

        val operationResult = history?.let {
            operation.forId(it, firstValue, secondValue)
        }

        operationResult.let {
            if(it != null)
                updateResult(it.getResult())
        }

        isFirstOperation = false
    }

    override fun handleDelete() {
        val oldValue = displayedNumber
        var newValue = "0"
        val len = oldValue.length
        var minLen = 1
        if (oldValue.contains("-")) {
            minLen++
        }

        if (len > minLen) {
            newValue = oldValue.substring(0, len - 1)
        }

        newValue = newValue.replace("\\.$".toRegex(), "")
        newValue = formatString(newValue)
        setValue(newValue)
        firstValue = newValue.stringToDouble()
    }

    override fun handleEquals() {
        if (lastKey == EQUALS.key) {
            calculateResult()
        }

        if (lastKey != DIGIT.key) {
            return
        }

        displayedNumber.let {
            secondValue = it.replace(",", "").toDouble()
        }
        calculateResult()
        lastKey = EQUALS.key
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
        PLUS.key -> "+"
        MINUS.key -> "-"
        MULTIPLY.key -> "*"
        DIVIDE.key -> "/"
        ROOT.key -> "√"
        POWER.key -> "^"
        PERCENT.key -> "%"
        else -> ""
    }

    override fun checkLastDigit() {

        when(lastKey) {
            EQUALS.key -> {
                history = EQUALS.key
            }
        }

        lastKey = DIGIT.key
        resetValueIfNeeded()
    }

    fun handleRoot() {
        firstValue = displayedNumber.stringToDouble()
        calculateResult()
    }

    fun handlePercent() {
        calculateResult()
    }
}