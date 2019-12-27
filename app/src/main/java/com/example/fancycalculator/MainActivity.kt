package com.example.fancycalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fancycalculator.model.OperationImpl
import com.example.fancycalculator.model.PLUS
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
    var calculator = CalculatorPresenter(operationImpl,this, applicationContext)

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

        ui.plusBtn.view.setOnClickListener {
            calculator.handleOperation(PLUS)
        }

        buttons.forEach {
            it.view.setOnClickListener {
                ui.result.text = "no"
            }
        }
    }

    override fun setValue(value: String, context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValueDouble(d: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFormula(value: String, context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
