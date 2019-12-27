package com.example.fancycalculator.view

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
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
                id = R.id.history
                hint = "Result here"
            }.lparams(org.jetbrains.anko.matchParent, org.jetbrains.anko.wrapContent) {
            }

            result = textView {
                id = R.id.result
                hint = "Result here"
            }.lparams(matchParent, wrapContent) {
            }

            linearLayout {
                id = R.id.bottom_container
                orientation = LinearLayout.HORIZONTAL
                backgroundColor = R.color.material_blue_grey_800

                linearLayout {
                    gravity = Gravity.BOTTOM
                    orientation = LinearLayout.VERTICAL
                    id = R.id.numbersLayout

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

                        sevenBtn =
                            include(ButtonItemUi("7")) {
                                view.id = R.id.button_seven
                            }
                        eightBtn =
                            include(ButtonItemUi("8")) {
                                view.id = R.id.button_eight
                            }
                        nineBtn =
                            include(ButtonItemUi("9")) {
                                view.id = R.id.button_nine
                            }
                        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                            weight = 1.0f
                        }
                    }

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

                        fourBtn =
                            include(ButtonItemUi("4")) {
                                view.id = R.id.button_four
                            }

                        fiveBtn =
                            include(ButtonItemUi("5")) {
                                view.id = R.id.button_five
                            }

                        sixBtn =
                            include(ButtonItemUi("6")) {
                                view.id = R.id.button_six
                            }
                        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                            weight = 1.0f
                        }
                    }

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

                        oneBtn =
                            include(ButtonItemUi("1")) {
                                view.id = R.id.button_one
                            }

                        twoBtn =
                            include(ButtonItemUi("2")) {
                                view.id = R.id.button_two
                            }

                        threeBtn =
                            include(ButtonItemUi("3")) {
                                view.id = R.id.button_three
                            }
                        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                            weight = 1.0f
                        }
                    }

                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL

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
                        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                            weight = 1.0f
                        }
                    }

                    layoutParams = LinearLayout.LayoutParams(wrapContent, matchParent).apply {
                        weight = 1.0f
                    }

                }



                linearLayout {
                    gravity = Gravity.BOTTOM
                    id = R.id.symbolsLayout

                    orientation = LinearLayout.VERTICAL

                    delBtn =
                        include(ButtonItemUi("DEL")) {
                            view.id = R.id.button_del
                        }

                    divideBtn =
                        include(ButtonItemUi("/")) {
                            view.id = R.id.button_divide
                        }

                    multiplyBtn =
                        include(ButtonItemUi("x")) {
                            view.id = R.id.button_multiply
                        }

                    minusBtn =
                        include(ButtonItemUi("-")) {
                            view.id = R.id.button_minus
                        }

                    plusBtn =
                        include(ButtonItemUi("+")) {
                            view.id = R.id.button_plus
                        }

                    layoutParams = LinearLayout.LayoutParams(wrapContent, matchParent).apply {
                        weight = 1.0f
                    }

                }
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent).apply {
                }
            }
            layoutParams = LinearLayout.LayoutParams(matchParent, matchParent).apply {

            }

        }
    }
}

class ButtonItemUi(number : String) : UiComponent() {
    var textBtn = number
    override fun createView() = layout {
        button {
            text = textBtn
            layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                weight = 1.0f
            }
        }
    }

}
