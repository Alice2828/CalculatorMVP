package com.example.calculatorkotlin.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorkotlin.R
import com.example.calculatorkotlin.contract.ContractInterface
import com.example.calculatorkotlin.presenter.PresenterActivity
import java.lang.Exception
import kotlin.math.sqrt

internal enum class Mode {
    START, PLUS, MINUS, DIVIDE, MULTIP, EQUAL, POW, PERCENT, SQRT, OPERATION
}

internal enum class Sign {
    PLUS, MINUS, DIVIDE, MULTIP, UNDEFINED, POW, PERCENT, SQRT, OPERATION
}

class MainActivity : AppCompatActivity(), View.OnClickListener, ContractInterface.View {
    private var textInput: TextView? = null
    private var buttonClear: Button? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null
    private var button0: Button? = null
    private var buttonMul: Button? = null
    private var buttonDiv: Button? = null
    private var buttonPlus: Button? = null
    private var buttonMinus: Button? = null
    private var buttonDot: Button? = null
    private var buttonEq: Button? = null
    private var buttonSqrt: Button? = null
    private var buttonPow: Button? = null
    private var buttonPercent: Button? = null
    private var buttonSin: Button? = null
    private var buttonCos: Button? = null
    private var buttonTan: Button? = null
    private var buttonFact: Button? = null
    private var buttonLn: Button? = null
    private var buttonLog: Button? = null
    private var dot = 0
    private var num1 = 0.0
    private var num2 = 0.0
    private var mode: Mode = Mode.START
    private var sign = Sign.UNDEFINED
    var negative = 0
    var second = 0
    private var presenter: PresenterActivity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterActivity(this)
        initView()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textInput?.text = savedInstanceState.getString("TextInput")
        second = savedInstanceState.getInt("Second")
        negative = savedInstanceState.getInt("Negative")
        sign = Sign.valueOf(savedInstanceState.getString("Sign").toString())
        mode = Mode.valueOf(savedInstanceState.getString("Mode").toString())
        dot = savedInstanceState.getInt("dot")
        num1 = savedInstanceState.getDouble("num1")
        num2 = savedInstanceState.getDouble("num2")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("TextInput", textInput!!.text.toString())
        outState.putString("Mode", mode.toString())
        outState.putInt("Second", second)
        outState.putInt("Negative", negative)
        outState.putString("Sign", sign.toString())
        outState.putInt("dot", dot)
        outState.putDouble("num1", num1)
        outState.putDouble("num2", num2)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.clear -> {
                try {
                    if (textInput?.text.toString() == "Infinity") {
                        textInput?.text = ""
                    }
                    if (textInput?.text.toString() == "Error") {
                        textInput?.text = ""
                    }
                    if (textInput?.text.toString().length != 1) {
                        try {
                            textInput?.text = textInput?.text.toString()
                                .substring(0, textInput?.text.toString().length - 1)
                            num1 = textInput?.text.toString().toDouble()
                        } catch (e: NumberFormatException) {
                            textInput?.text = "" //erases one by one
                        }
                    } else textInput?.text = ""
                    dot = if (textInput?.text.toString().contains(".")) {
                        1
                    } else 0
                    negative = 0
                } catch (e: Exception) {
                }
            }
            R.id.dot -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString().contains(".")) dot = 1
                if (dot != 1) {
                    if (textInput?.text.toString().length == 0) textInput!!.text = "0"
                    textInput?.append(".")
                }
                dot = 1
            }
            R.id.one -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput!!.text = ""
                textInput?.append("1")
            }
            R.id.two -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("2")
            }
            R.id.three -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("3")
            }
            R.id.four -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("4")
            }
            R.id.five -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput!!.append("5")
            }
            R.id.six -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("6")
            }
            R.id.seven -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("7")
            }
            R.id.eight -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput!!.append("8")
            }
            R.id.nine -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString() === "0") textInput?.text = ""
                textInput?.append("9")
            }
            R.id.zero -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                if (mode != Mode.START && mode != Mode.EQUAL && negative == 0 || second == 1) {
                    mode = Mode.START
                    textInput?.text = ""
                    second = 0
                }
                if (textInput?.text.toString().length == 0 || textInput?.text.toString()[0] == '0' && dot == 0) {
                    textInput?.text = "0"
                } else if (textInput?.text.toString()
                        .contains(".")
                ) textInput?.append("0") else textInput?.append("0")
            }
            R.id.plus -> {
                mode = Mode.PLUS
                sign = Sign.PLUS
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Error"
                }
                dot = 0
                second = 1
            }
            R.id.minus -> {
                mode = Mode.MINUS
                sign = Sign.MINUS
                if (textInput?.text.toString() === "Infinity") textInput!!.text = ""
                if (textInput?.text.toString() === "Error") textInput!!.text = ""
                if (textInput?.text!!.isEmpty()) {
                    textInput!!.append("-")
                    negative = 1
                } else {
                    num1 = textInput?.text.toString().toDouble()
                    second = 1
                }
            }
            R.id.multip -> {
                mode = Mode.MULTIP
                sign = Sign.MULTIP
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Error"
                }
                dot = 0
                second = 1
            }
            R.id.divide -> {
                mode = Mode.DIVIDE
                sign = Sign.DIVIDE
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Infinity"
                }
                dot = 0
                second = 1
            }
            R.id.sqrt -> {
                mode = Mode.SQRT
                sign = Sign.SQRT
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Infinity"
                }
                dot = 0
                textInput?.text = String.format("%.0f", sqrt(num1))
                mode = Mode.EQUAL
                second = 1
            }
            R.id.percent -> {
                mode = Mode.PERCENT
                sign = Sign.PERCENT
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Infinity"
                }
                dot = 0
            }
            R.id.pow -> {
                mode = Mode.POW
                sign = Sign.POW
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num1 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput?.text = "Infinity"
                }
                dot = 0
                second = 1
            }
            R.id.eq -> {
                if (textInput?.text.toString() == "Infinity") {
                    textInput?.text = ""
                }
                if (textInput?.text.toString() == "Error") {
                    textInput?.text = ""
                }
                try {
                    num2 = textInput?.text.toString().toDouble()
                } catch (e: NumberFormatException) {
                    textInput!!.text = "Infinity"
                }
                if (sign == Sign.PLUS) textInput?.text =
                    String.format(
                        "%.0f",
                        num1 + num2
                    ) else if (sign == Sign.MINUS) textInput?.text =
                    String.format(
                        "%.0f",
                        num1 - num2
                    ) else if (sign == Sign.MULTIP) textInput?.text =
                    String.format("%.0f", num1 * num2) else if (sign == Sign.DIVIDE) {
                    if (num2 == 0.0) textInput?.text = "Error" else textInput?.text =
                        String.format("%.0f", num1 / num2)
                } else if (sign == Sign.POW) textInput?.text = String.format(
                    "%.0f",
                    Math.pow(
                        num1,
                        num2
                    )
                )
                else if (sign == Sign.PERCENT) textInput?.text =
                    String.format("%.0f", num1 * 0.01) else textInput?.text = "Error"
                mode = Mode.EQUAL
            }
        }
//        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            when (v.id) {
//                R.id.sin -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    if (textInput!!.text.toString() == "Infinity") {
//                        textInput!!.text = ""
//                    }
//                    if (textInput!!.text.toString() == "Error") {
//                        textInput!!.text = ""
//                    }
//                    try {
//                        num1 = textInput!!.text.toString().toDouble()
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    dot = 0
//                    textInput!!.text = java.lang.Double.toString(Math.sin(num1))
//                    mode = Mode.EQUAL
//                    second = 1
//                }
//                R.id.cos -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    if (textInput!!.text.toString() == "Infinity") {
//                        textInput!!.text = ""
//                    }
//                    if (textInput!!.text.toString() == "Error") {
//                        textInput!!.text = ""
//                    }
//                    try {
//                        num1 = textInput!!.text.toString().toDouble()
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    dot = 0
//                    textInput!!.text = java.lang.Double.toString(Math.cos(num1))
//                    mode = Mode.EQUAL
//                    second = 1
//                }
//                R.id.tan -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    if (textInput!!.text.toString() == "Infinity") {
//                        textInput!!.text = ""
//                    }
//                    if (textInput!!.text.toString() == "Error") {
//                        textInput!!.text = ""
//                    }
//                    try {
//                        num1 = textInput!!.text.toString().toDouble()
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    dot = 0
//                    textInput!!.text = java.lang.Double.toString(Math.tan(num1))
//                    mode = Mode.EQUAL
//                    second = 1
//                }
//                R.id.fact -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    var s: Long = 0
//                    if (textInput!!.text.toString() == "Infinity") {
//                        textInput!!.text = ""
//                    }
//                    if (textInput!!.text.toString() == "Error") {
//                        textInput!!.text = ""
//                    }
//                    try {
//                        s = 1
//                        num1 = Math.abs(textInput!!.text.toString().toInt()).toDouble()
//                        var i = 1
//                        while (i <= num1) {
//                            s *= i.toLong()
//                            i++
//                        }
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    if (s == 0L) textInput!!.text = "Error" else textInput!!.text =
//                        java.lang.Long.toString(s)
//                    dot = 0
//                    mode = EQUAL
//                    second = 1
//                }
//                R.id.ln -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    if (textInput!!.text.toString() == "Infinity") {
//                        textInput!!.text = ""
//                    }
//                    if (textInput!!.text.toString() == "Error") {
//                        textInput!!.text = ""
//                    }
//                    try {
//                        num1 = textInput!!.text.toString().toDouble()
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    dot = 0
//                    textInput!!.text = java.lang.Double.toString(Math.log(num1))
//                    mode = Mode.EQUAL
//                    second = 1
//                }
//                R.id.log -> {
//                    mode = Mode.OPERATION
//                    sign = Sign.OPERATION
//                    simple()
//                    try {
//                        num1 = textInput!!.text.toString().toDouble()
//                    } catch (e: NumberFormatException) {
//                        textInput!!.text = "Infinity"
//                    }
//                    dot = 0
//                    textInput!!.text = java.lang.Double.toString(Math.log10(num1))
//                    mode = Mode.EQUAL
//                    second = 1
//                }
//            }
//        }
    }

    override fun initView() {
        textInput = findViewById(R.id.input)
        buttonEq = findViewById(R.id.eq)
        buttonClear = findViewById(R.id.clear)
        button1 = findViewById(R.id.one)
        button2 = findViewById(R.id.two)
        button3 = findViewById(R.id.three)
        button4 = findViewById(R.id.four)
        button5 = findViewById(R.id.five)
        button6 = findViewById(R.id.six)
        button7 = findViewById(R.id.seven)
        button8 = findViewById(R.id.eight)
        button9 = findViewById(R.id.nine)
        button0 = findViewById(R.id.zero)
        buttonMul = findViewById(R.id.multip)
        buttonDiv = findViewById(R.id.divide)
        buttonPlus = findViewById(R.id.plus)
        buttonMinus = findViewById(R.id.minus)
        buttonDot = findViewById(R.id.dot)
        buttonSqrt = findViewById(R.id.sqrt)
        buttonPow = findViewById(R.id.pow)
        buttonPercent = findViewById(R.id.percent)

//        buttonClear?.setOnClickListener(this)
//        buttonClear?.setOnLongClickListener { v ->
//            try {
//                if (textInput?.text.toString() == "Infinity") {
//                    textInput?.text = ""
//                }
//                if (v.id == R.id.clear) {
//                    textInput?.setText("")
//                    num1 = 0.0
//                    num2 = 0.0
//                    mode = Mode.START
//                    sign = Sign.UNDEFINED
//                    dot = 0
//                    negative = 0
//                }
//            } catch (e: Exception) {
//            }
//            true
//        }

//        button1?.setOnClickListener(this)
//        button2?.setOnClickListener(this)
//        button3?.setOnClickListener(this)
//        button4?.setOnClickListener(this)
//        button5?.setOnClickListener(this)
//        button6?.setOnClickListener(this)
//        button7?.setOnClickListener(this)
//        button8?.setOnClickListener(this)
//        button9?.setOnClickListener(this)
//        button0?.setOnClickListener(this)
//        buttonMul?.setOnClickListener(this)
//        buttonDiv?.setOnClickListener(this)
//        buttonPlus?.setOnClickListener(this)
//        buttonMinus?.setOnClickListener(this)
//        buttonDot?.setOnClickListener(this)
//        buttonEq?.setOnClickListener(this)
//        buttonSqrt?.setOnClickListener(this)
//        buttonPow?.setOnClickListener(this)
//        buttonPercent?.setOnClickListener(this)

//        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            buttonSin = findViewById(R.id.sin)
//            buttonCos = findViewById(R.id.cos)
//            buttonTan = findViewById(R.id.tan)
//            buttonFact = findViewById(R.id.fact)
//            buttonLn = findViewById(R.id.ln)
//            buttonLog = findViewById(R.id.log)
//            buttonSin?.setOnClickListener(this)
//            buttonCos?.setOnClickListener(this)
//            buttonTan?.setOnClickListener(this)
//            buttonFact?.setOnClickListener(this)
//            buttonLn?.setOnClickListener(this)
//            buttonLog?.setOnClickListener(this)
//        }
        textInput?.text = presenter?.getData()
      //  clickButton.setOnClickListener { presenter?.update() }
        button1?.setOnClickListener{ presenter?.update() }
        button2?.setOnClickListener{ presenter?.update() }
        button3?.setOnClickListener{ presenter?.update() }
        button4?.setOnClickListener{ presenter?.update() }
        button5?.setOnClickListener{ presenter?.update() }
        button6?.setOnClickListener{ presenter?.update() }
        button7?.setOnClickListener{ presenter?.update() }
        button8?.setOnClickListener{ presenter?.update() }
        button9?.setOnClickListener{ presenter?.update() }
        button0?.setOnClickListener{ presenter?.update() }
        buttonMul?.setOnClickListener{ presenter?.update() }
        buttonDiv?.setOnClickListener{ presenter?.update() }
        buttonPlus?.setOnClickListener{ presenter?.update() }
        buttonMinus?.setOnClickListener{ presenter?.update() }
        buttonDot?.setOnClickListener{ presenter?.update() }
        buttonEq?.setOnClickListener{ presenter?.update() }
        buttonSqrt?.setOnClickListener{ presenter?.update() }
        buttonPow?.setOnClickListener{ presenter?.update() }
        buttonPercent?.setOnClickListener{ presenter?.update() }
    }

    override fun updateViewData() {
        textInput?.text = presenter?.getData()
    }

//    private fun simple() {
//        if (textInput?.text.toString() == "Infinity") {
//            textInput?.text = ""
//        }
//        if (textInput?.text.toString() == "Error") {
//            textInput?.text = ""
//        }
//    }
//
//    companion object {
//        private const val KEY_TextInput = "TextInput"
//        private const val KEY_Second = "Second"
//        private const val KEY_Negative = "Negative"
//        private const val KEY_Mode = "Mode"
//        private const val KEY_Sign = "Sign"
//        private const val KEY_dot = "dot"
//        private const val KEY_num1 = "num1"
//        private const val KEY_num2 = "num2"
//    }
}
