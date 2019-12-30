package com.example.fancycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fancycalculator.model.*
import com.example.fancycalculator.presenter.CalculatorPresenter
import com.example.fancycalculator.view.ButtonItemUi
import com.example.fancycalculator.view.Calculator
import com.example.fancycalculator.view.MainActivityUi
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), Calculator {

    private val ui = MainActivityUi()
    lateinit var buttons: List<ButtonItemUi>
    var operationImpl = OperationImpl()
    lateinit var calculator : CalculatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        setUp(ui)
    }

    private fun setUp(ui: MainActivityUi) {
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
        calculator = CalculatorPresenter(operationImpl,this)
        ui.plusBtn.view.onClick {
            calculator.handleOperation(PLUS)
        }
        ui.minusBtn.view.onClick {
            calculator.handleOperation(MINUS)
        }
        ui.multiplyBtn.view.onClick {
            calculator.handleOperation(MULTIPLY)
        }
        ui.divideBtn.view.onClick {
            calculator.handleOperation(DIVIDE)
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
                it?.id?.let { it1 -> calculator.numberClicked(it1) }
            }
        }
    }

    override fun setValue(value: String) {
        ui.result.text = value
    }

    override fun setFormula(value: String) {
        ui.history.text = value
    }
}
