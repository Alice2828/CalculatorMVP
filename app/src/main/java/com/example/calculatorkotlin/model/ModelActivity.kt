package com.example.calculatorkotlin.model

import com.example.calculatorkotlin.contract.ContractInterface
import com.example.calculatorkotlin.view.Mode
import com.example.calculatorkotlin.view.Sign
import java.lang.Exception
import kotlin.math.log10
import kotlin.math.pow

class ModelActivity : ContractInterface.Model {
    private var dot = 0
    private var num1 = 0.0
    private var num2 = 0.0
    private var mode: Mode = Mode.START
    private var sign = Sign.UNDEFINED
    private var negative = 0
    private var second = 0
    private var data = ""

    override fun getData() = data

    override fun clear() {
        try {
            if (data == "Infinity") {
                data = ""
            }
            if (data == "Error") {
                data = ""
            }
            if (data.length != 1) {
                try {
                    data = data
                        .substring(0, data.length - 1)
                    num1 = data.toDouble()
                } catch (e: NumberFormatException) {
                    data = "" //erases one by one
                }
            } else data = ""
            dot = if (data.contains(".")) {
                1
            } else 0
            negative = 0
        } catch (e: Exception) {
        }
    }

    override fun clearAll() {
        try {
            data = ""
            num1 = 0.0
            num2 = 0.0
            mode = Mode.START
            sign = Sign.UNDEFINED
            dot = 0
            negative = 0

        } catch (e: Exception) {
        }
    }

    override fun dot() {
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        if (data.contains(".")) dot = 1
        if (dot != 1) {
            if (data.isEmpty()) data = "0"
            data += "."
        }
        dot = 1
    }

    override fun number(numb: Int) {
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
            mode = Mode.START
            data = ""
            second = 0
        }
        if (data === "0") data = ""
        data += numb.toString()

    }

    override fun zero() {
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
            mode = Mode.START
            data = ""
            second = 0
        }
        if (data.isEmpty() || data[0] == '0' && dot == 0) {
            data = "0"
        } else if (data
                .contains(".")
        ) data += "0" else data += "0"
    }

    override fun plus() {
        mode = Mode.PLUS
        sign = Sign.PLUS
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Error"
        }
        dot = 0
        second = 1
    }

    override fun minus() {
        mode = Mode.MINUS
        sign = Sign.MINUS
        if (data === "Infinity") data = ""
        if (data === "Error") data = ""
        if (data.isEmpty()) {
            data += "-"
            negative = 1
        } else {
            num1 = data.toDouble()
            second = 1
        }
    }

    override fun multip() {
        mode = Mode.MULTIP
        sign = Sign.MULTIP
        if (data == "Infinity") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Error"
        }
        dot = 0
        second = 1
    }

    override fun divide() {
        mode = Mode.DIVIDE
        sign = Sign.DIVIDE
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        second = 1
    }

    override fun sqrt() {
        mode = Mode.SQRT
        sign = Sign.SQRT
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.0f", kotlin.math.sqrt(num1))
        mode = Mode.EQUAL
        second = 1
    }

    override fun percent() {
        mode = Mode.PERCENT
        sign = Sign.PERCENT
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
    }

    override fun pow() {
        mode = Mode.POW
        sign = Sign.POW
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        second = 1
    }

    override fun sin() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.2f", kotlin.math.sin(num1))
        mode = Mode.EQUAL
        second = 1
    }

    override fun cos() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.2f", kotlin.math.cos(num1))
        mode = Mode.EQUAL
        second = 1
    }

    override fun tan() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.2f", kotlin.math.tan(num1))
        mode = Mode.EQUAL
        second = 1
    }

    override fun fact() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        var s: Long = 0
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            s = 1
            num1 = Math.abs(data.toInt()).toDouble()
            var i = 1
            while (i <= num1) {
                s *= i.toLong()
                i++
            }
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        if (s == 0L) data = "Error" else data =
            s.toString()
        dot = 0
        mode = Mode.EQUAL
        second = 1
    }

    override fun ln() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.2f", kotlin.math.ln(num1))
        mode = Mode.EQUAL
        second = 1
    }

    override fun log() {
        mode = Mode.OPERATION
        sign = Sign.OPERATION
        simple()
        try {
            num1 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        dot = 0
        data = String.format("%.2f", log10(num1))
        mode = Mode.EQUAL
        second = 1
    }

    private fun simple() {
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
    }

    override fun eq() {
        if (data == "Infinity") {
            data = ""
        }
        if (data == "Error") {
            data = ""
        }
        try {
            num2 = data.toDouble()
        } catch (e: NumberFormatException) {
            data = "Infinity"
        }
        if (sign == Sign.PLUS) data =
            String.format(
                "%.2f",
                num1 + num2
            ) else if (sign == Sign.MINUS) data =
            String.format(
                "%.2f",
                num1 - num2
            ) else if (sign == Sign.MULTIP) data =
            String.format("%.2f", num1 * num2) else if (sign == Sign.DIVIDE) {
            data = if (num2 == 0.0) "Error" else String.format("%.2f", num1 / num2)
        } else if (sign == Sign.POW) data = String.format(
            "%.2f",
            num1.pow(num2)
        )
        else if (sign == Sign.PERCENT) data =
            String.format("%.2f", num1 * 0.01) else data = "Error"
        mode = Mode.EQUAL
    }

    override fun getDot() = dot
    override fun getNum1() = num1
    override fun getNum2() = num2
    override fun getMode() = mode
    override fun getSign() = sign
    override fun getNegative() = negative
    override fun getSecond() = second

    override fun setDot(dot: Int) {
        this.dot = dot
    }

    override fun setNum1(num1: Double) {
        this.num1 = num1
    }

    override fun setNum2(num2: Double) {
        this.num2 = num2
    }

    override fun setMode(mode: Mode) {
        this.mode = mode
    }

    override fun setSign(sign: Sign) {
        this.sign = sign
    }

    override fun setNegative(negative: Int) {
        this.negative = negative
    }

    override fun setSecond(second: Int) {
        this.second = second
    }

    override fun setData(data: String) {
        this.data = data
    }


}
