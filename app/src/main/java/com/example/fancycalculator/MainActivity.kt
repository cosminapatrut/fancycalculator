package com.example.fancycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fancycalculator.model.*
import com.example.fancycalculator.model.OperationType.*
import com.example.fancycalculator.presenter.CalculatorPresenterImpl
import com.example.fancycalculator.view.ButtonItemUi
import com.example.fancycalculator.view.Calculator
import com.example.fancycalculator.view.MainActivityUi
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), Calculator {

    private val ui = MainActivityUi()
    lateinit var buttons: List<ButtonItemUi>
    var operationImpl = OperationFactoryImpl()
    lateinit var calculator : CalculatorPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        setUpNavigationDrawer()
        setUp()
    }

    private fun setUp() {
        buttons = listOf(
            ui.zeroBtn,
            ui.oneBtn,
            ui.twoBtn,
            ui.threeBtn,
            ui.fourBtn,
            ui.fiveBtn,
            ui.sixBtn,
            ui.sevenBtn,
            ui.eightBtn,
            ui.nineBtn
        )
        calculator = CalculatorPresenterImpl(operationImpl,this)
        ui.plusBtn.view.onClick {
            calculator.handleOperation(PLUS.key)
        }
        ui.minusBtn.view.onClick {
            calculator.handleOperation(MINUS.key)
        }
        ui.multiplyBtn.view.onClick {
            calculator.handleOperation(MULTIPLY.key)
        }
        ui.divideBtn.view.onClick {
            calculator.handleOperation(DIVIDE.key)
        }
        ui.rootBtn.view.onClick {
            calculator.handleOperation(ROOT.key)
        }
        ui.powerBtn.view.onClick {
            calculator.handleOperation(POWER.key)
        }
        ui.percentBtn.view.onClick {
            calculator.handleOperation(PERCENT.key)
        }
        ui.equalBtn.view.onClick {
            calculator.handleEquals()
        }
        ui.delBtn.view.onClick {
            calculator.handleDelete()
        }
        ui.dotBtn.view.onClick {
            calculator.handleDot()
        }

        buttons.forEach { it ->
            it.view.onClick {
                it?.id?.let {
                        numberId -> numberClicked(numberId)
                }
            }
        }
    }

    private fun setUpNavigationDrawer() {

    }

    override fun setValue(value: String) {
        ui.result.text = value
    }

    override fun setFormula(value: String) {
        ui.history.text = value
    }

    fun numberClicked(id: Int) {
        calculator.checkLastDigit()
        when (id) {
            R.id.button_zero -> calculator.zeroClicked()
            R.id.button_one -> calculator.addDigit(1)
            R.id.button_two -> calculator.addDigit(2)
            R.id.button_three -> calculator.addDigit(3)
            R.id.button_four -> calculator.addDigit(4)
            R.id.button_five -> calculator.addDigit(5)
            R.id.button_six -> calculator.addDigit(6)
            R.id.button_seven -> calculator.addDigit(7)
            R.id.button_eight -> calculator.addDigit(8)
            R.id.button_nine -> calculator.addDigit(9)
        }
    }
}