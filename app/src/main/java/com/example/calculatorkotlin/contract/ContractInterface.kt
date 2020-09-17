package com.example.calculatorkotlin.contract

import com.example.calculatorkotlin.view.Mode
import com.example.calculatorkotlin.view.Sign

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getData(): String
        fun clear()
        fun clearAll()
        fun dot()
        fun number(numb: Int)
        fun zero()
        fun plus()
        fun minus()
        fun multip()
        fun divide()
        fun sqrt()
        fun percent()
        fun pow()
        fun sin()
        fun cos()
        fun tan()
        fun fact()
        fun ln()
        fun log()
        fun eq()
        fun getDot(): Int
        fun getNum1(): Double
        fun getNum2(): Double
        fun getMode(): Mode
        fun getSign(): Sign
        fun getNegative(): Int
        fun getSecond(): Int

        fun setDot(dot: Int)
        fun setNum1(num1: Double)
        fun setNum2(num2: Double)
        fun setMode(mode: Mode)
        fun setSign(sign: Sign)
        fun setNegative(negative: Int)
        fun setSecond(second: Int)
        fun setData(data: String)
    }

    interface Model {
        fun getData(): String
        fun clear()
        fun clearAll()
        fun dot()
        fun number(numb: Int)
        fun zero()
        fun plus()
        fun minus()
        fun multip()
        fun divide()
        fun sqrt()
        fun percent()
        fun pow()
        fun eq()
        fun sin()
        fun cos()
        fun tan()
        fun fact()
        fun ln()
        fun log()
        fun getDot(): Int
        fun getNum1(): Double
        fun getNum2(): Double
        fun getMode(): Mode
        fun getSign(): Sign
        fun getNegative(): Int
        fun getSecond(): Int

        fun setDot(dot: Int)
        fun setNum1(num1: Double)
        fun setNum2(num2: Double)
        fun setMode(mode: Mode)
        fun setSign(sign: Sign)
        fun setNegative(negative: Int)
        fun setSecond(second: Int)
        fun setData(data: String)

    }

}