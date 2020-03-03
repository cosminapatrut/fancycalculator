package com.example.fancycalculator.model

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun String.stringToDouble() = this.replace(",", "").toDouble()

fun Double.doubleToString():  String {
    val symbols = DecimalFormatSymbols(Locale.getDefault())
    symbols.decimalSeparator = '.'
    symbols.groupingSeparator = ','

    val formatter = DecimalFormat()
    formatter.maximumFractionDigits = 12
    formatter.decimalFormatSymbols =  symbols
    formatter.isGroupingUsed = true

    return formatter.format(this)
}