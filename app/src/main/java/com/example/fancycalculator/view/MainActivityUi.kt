package com.example.fancycalculator.view

import android.graphics.Color
import android.os.Build
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.fancycalculator.R
import org.jetbrains.anko.*

class MainActivityUi : UiComponent() {

    lateinit var history: TextView
    lateinit var result: TextView
    lateinit var zeroBtn: ButtonItemUi
    lateinit var oneBtn: ButtonItemUi
    lateinit var twoBtn: ButtonItemUi
    lateinit var threeBtn: ButtonItemUi
    lateinit var fourBtn: ButtonItemUi
    lateinit var fiveBtn: ButtonItemUi
    lateinit var sixBtn: ButtonItemUi
    lateinit var sevenBtn: ButtonItemUi
    lateinit var eightBtn: ButtonItemUi
    lateinit var nineBtn: ButtonItemUi
    lateinit var dotBtn: ButtonItemUi
    lateinit var equalBtn: ButtonItemUi
    lateinit var delBtn: ButtonItemUi
    lateinit var divideBtn: ButtonItemUi
    lateinit var multiplyBtn: ButtonItemUi
    lateinit var minusBtn: ButtonItemUi
    lateinit var plusBtn: ButtonItemUi

    override fun createView() = layout {
        verticalLayout {
            gravity = Gravity.BOTTOM
            history = textView {
                gravity = Gravity.RIGHT
                id = R.id.history
                hint = "Result here"
                textColor = Color.BLACK
                textSize = 16f
            }.lparams(matchParent, dip(100))
            result = textView {
                id = R.id.result
                gravity = Gravity.RIGHT
                text = "Output here"
                textColor = Color.BLACK
                textSize = 19f
            }.lparams(matchParent, dip(100))
            linearLayout {
                id = R.id.bottom_container
                orientation = LinearLayout.HORIZONTAL
                backgroundColor = Color.BLACK
                linearLayout {
                    gravity = Gravity.BOTTOM
                    orientation = LinearLayout.VERTICAL
                    id = R.id.numbersLayout
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        backgroundColor = Color.BLACK
                        sevenBtn = include(ButtonItemUi("7")) {
                            view.id = R.id.button_seven
                        }
                        eightBtn = include(ButtonItemUi("8")) {
                            view.id = R.id.button_eight
                        }
                        nineBtn = include(ButtonItemUi("9")) {
                            view.id = R.id.button_nine
                        }
                    }.lparams(wrapContent, wrapContent) {
                        weight = 1.0f
                    }
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        backgroundColor = Color.BLACK
                        fourBtn = include(ButtonItemUi("4")) {
                            view.id = R.id.button_four
                        }
                        fiveBtn = include(ButtonItemUi("5")) {
                            view.id = R.id.button_five
                        }
                        sixBtn = include(ButtonItemUi("6")) {
                            view.id = R.id.button_six
                        }
                    }.lparams(wrapContent, wrapContent) {
                        weight = 1.0f
                    }
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        backgroundColor = Color.BLACK
                        oneBtn = include(ButtonItemUi("1")) {
                            view.id = R.id.button_one
                        }
                        twoBtn = include(ButtonItemUi("2")) {
                            view.id = R.id.button_two
                        }
                        threeBtn = include(ButtonItemUi("3")) {
                            view.id = R.id.button_three
                        }
                    }.lparams(wrapContent, wrapContent) {
                        weight = 1.0f
                    }
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        backgroundColor = Color.BLACK
                        dotBtn =
                            include(ButtonItemUi(".")) {
                                view.id = R.id.button_dot
                            }
                        zeroBtn =
                            include(ButtonItemUi("0")) {
                                view.id = R.id.button_zero
                            }
                        equalBtn =
                            include(ButtonItemUi("=")) {
                                view.id = R.id.button_equal
                            }
                    }.lparams(wrapContent, wrapContent) {
                        weight = 1.0f
                    }
                }.lparams(wrapContent, matchParent) {
                    weight = 1.0f
                }
                linearLayout {
                    gravity = Gravity.BOTTOM
                    id = R.id.symbolsLayout
                    backgroundColor = Color.BLACK
                    orientation = LinearLayout.VERTICAL
                    delBtn = include(ButtonItemUi("DEL")) {
                        view.id = R.id.button_del
                    }
                    divideBtn = include(ButtonItemUi("/")) {
                        view.id = R.id.button_divide
                    }
                    multiplyBtn = include(ButtonItemUi("x")) {
                        view.id = R.id.button_multiply
                    }
                    minusBtn = include(ButtonItemUi("-")) {
                        view.id = R.id.button_minus
                    }
                    plusBtn = include(ButtonItemUi("+")) {
                        view.id = R.id.button_plus
                    }
                }.lparams(wrapContent, matchParent) {
                    weight = 1.0f
                }

                linearLayout{
                id = R.id.right_drawer
                backgroundColor = Color.YELLOW
                    imageView {
                        id = R.id.swipe_left_chevron
                        backgroundResource = R.drawable.ic_left_chevron
                    }.lparams(wrapContent, wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                    }
                }.lparams(dip(10), matchParent)
            }.lparams(matchParent, dip(400))
            layoutParams = LinearLayout.LayoutParams(matchParent, matchParent).apply {
            }
        }
    }
}

class ButtonItemUi(number: String) : UiComponent() {
    var textBtn = number
    override fun createView() = layout {
        button {
            backgroundColor = Color.BLACK
            textColor = Color.YELLOW
            text = textBtn
            layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                weight = 1.0f
            }
        }
    }
}