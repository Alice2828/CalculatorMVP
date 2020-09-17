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

enum class Mode {
    START, PLUS, MINUS, DIVIDE, MULTIP, EQUAL, POW, PERCENT, SQRT, OPERATION
}

enum class Sign {
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

    private var presenter: PresenterActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterActivity(this)
        initView()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("TextInput")?.let { presenter?.setData(it) }
        presenter?.setSecond(savedInstanceState.getInt("Second"))
        presenter?.setNegative(savedInstanceState.getInt("Negative"))
        presenter?.setSign(Sign.valueOf(savedInstanceState.getString("Sign").toString()))
        presenter?.setMode(Mode.valueOf(savedInstanceState.getString("Mode").toString()))
        presenter?.setDot(savedInstanceState.getInt("dot"))
        presenter?.setNum1(savedInstanceState.getDouble("num1"))
        presenter?.setNum2(savedInstanceState.getDouble("num2"))
        updateViewData()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("TextInput", textInput!!.text.toString())
        outState.putString("Mode", presenter?.getMode().toString())
        presenter?.getSecond()?.let { outState.putInt("Second", it) }
        presenter?.getNegative()?.let { outState.putInt("Negative", it) }
        outState.putString("Sign", presenter?.getSign().toString())
        presenter?.getDot()?.let { outState.putInt("dot", it) }
        presenter?.getNum1()?.let { outState.putDouble("num1", it) }
        presenter?.getNum2()?.let { outState.putDouble("num2", it) }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.clear -> {
                presenter?.clear()
            }
            R.id.dot -> {
                presenter?.dot()
            }
            R.id.one -> {
                presenter?.number(1)
            }
            R.id.two -> {
                presenter?.number(2)
            }
            R.id.three -> {
                presenter?.number(3)
            }
            R.id.four -> {
                presenter?.number(4)
            }
            R.id.five -> {
                presenter?.number(5)
            }
            R.id.six -> {
                presenter?.number(6)
            }
            R.id.seven -> {
                presenter?.number(7)
            }
            R.id.eight -> {
                presenter?.number(8)
            }
            R.id.nine -> {
                presenter?.number(9)
            }
            R.id.zero -> {
                presenter?.zero()
            }
            R.id.plus -> {
                presenter?.plus()
            }
            R.id.minus -> {
                presenter?.minus()
            }
            R.id.multip -> {
                presenter?.multip()
            }
            R.id.divide -> {
                presenter?.divide()
            }
            R.id.sqrt -> {
                presenter?.sqrt()
            }
            R.id.percent -> {
                presenter?.percent()
            }
            R.id.pow -> {
                presenter?.pow()
            }
            R.id.eq -> {
                presenter?.eq()
            }
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            when (v.id) {
                R.id.sin -> {
                    presenter?.sin()
                }
                R.id.cos -> {
                    presenter?.cos()
                }
                R.id.tan -> {
                    presenter?.tan()
                }
                R.id.fact -> {
                    presenter?.fact()
                }
                R.id.ln -> {
                    presenter?.ln()
                }
                R.id.log -> {
                    presenter?.log()
                }
            }
        }
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

        buttonClear?.setOnClickListener(this)
        buttonClear?.setOnLongClickListener {
            presenter?.clearAll()
            true
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonSin = findViewById(R.id.sin)
            buttonCos = findViewById(R.id.cos)
            buttonTan = findViewById(R.id.tan)
            buttonFact = findViewById(R.id.fact)
            buttonLn = findViewById(R.id.ln)
            buttonLog = findViewById(R.id.log)
            buttonSin?.setOnClickListener(this)
            buttonCos?.setOnClickListener(this)
            buttonTan?.setOnClickListener(this)
            buttonFact?.setOnClickListener(this)
            buttonLn?.setOnClickListener(this)
            buttonLog?.setOnClickListener(this)
        }
        textInput?.text = presenter?.getData()
        //  clickButton.setOnClickListener { presenter?.update() }
        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
        button4?.setOnClickListener(this)
        button5?.setOnClickListener(this)
        button6?.setOnClickListener(this)
        button7?.setOnClickListener(this)
        button8?.setOnClickListener(this)
        button9?.setOnClickListener(this)
        button0?.setOnClickListener(this)
        buttonMul?.setOnClickListener(this)
        buttonDiv?.setOnClickListener(this)
        buttonPlus?.setOnClickListener(this)
        buttonMinus?.setOnClickListener(this)
        buttonDot?.setOnClickListener(this)
        buttonEq?.setOnClickListener(this)
        buttonSqrt?.setOnClickListener(this)
        buttonPow?.setOnClickListener(this)
        buttonPercent?.setOnClickListener(this)
    }

    override fun updateViewData() {
        textInput?.text = presenter?.getData()
    }

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
