package com.example.fancycalculator.model

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

object Converter {
//    fun doubleToString(d: Double): String {
//        val symbols = DecimalFormatSymbols(Locale.getDefault())
//        symbols.decimalSeparator = '.'
//        symbols.groupingSeparator = ','
//
//        val formatter = DecimalFormat()
//        formatter.maximumFractionDigits = 12
//        formatter.decimalFormatSymbols = symbols
//        formatter.isGroupingUsed = true
//        return formatter.format(d)
//    }

//    fun stringToDouble(str: String) = str.replace(",", "").toDouble()
}

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