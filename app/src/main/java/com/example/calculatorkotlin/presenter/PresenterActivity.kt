package com.example.calculatorkotlin.presenter

import com.example.calculatorkotlin.contract.ContractInterface
import com.example.calculatorkotlin.model.ModelActivity
import com.example.calculatorkotlin.view.Mode
import com.example.calculatorkotlin.view.Sign

class PresenterActivity(_view: ContractInterface.View) : ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = ModelActivity()

    init {
        view.initView()
    }

    override fun clear() {
        model.clear()
        view.updateViewData()
    }

    override fun clearAll() {
        model.clearAll()
        view.updateViewData()
    }

    override fun dot() {
        model.dot()
        view.updateViewData()
    }

    override fun number(numb: Int) {
        model.number(numb)
        view.updateViewData()
    }

    override fun getData() = model.getData()
    override fun zero() {
        model.zero()
        view.updateViewData()
    }

    override fun plus() {
        model.plus()
        view.updateViewData()
    }

    override fun minus() {
        model.minus()
        view.updateViewData()
    }

    override fun multip() {
        model.multip()
        view.updateViewData()
    }

    override fun divide() {
        model.divide()
        view.updateViewData()
    }

    override fun sqrt() {
        model.sqrt()
        view.updateViewData()
    }

    override fun percent() {
        model.percent()
        view.updateViewData()
    }

    override fun pow() {
        model.percent()
        view.updateViewData()
    }

    override fun sin() {
        model.sin()
        view.updateViewData()
    }

    override fun cos() {
        model.cos()
        view.updateViewData()
    }

    override fun tan() {
        model.tan()
        view.updateViewData()
    }

    override fun fact() {
        model.fact()
        view.updateViewData()
    }

    override fun ln() {
        model.ln()
        view.updateViewData()
    }

    override fun log() {
        model.log()
        view.updateViewData()
    }

    override fun eq() {
        model.eq()
        view.updateViewData()
    }

    override fun getDot() = model.getDot()
    override fun getNum1() = model.getNum1()
    override fun getNum2() = model.getNum2()
    override fun getMode() = model.getMode()
    override fun getSign() = model.getSign()
    override fun getNegative() = model.getNegative()
    override fun getSecond() = model.getSecond()


    override fun setDot(dot: Int) {
        model.setDot(dot)
    }

    override fun setNum1(num1: Double) {
        model.setNum1(num1)
    }

    override fun setNum2(num2: Double) {
        model.setNum2(num2)
    }

    override fun setMode(mode: Mode) {
        model.setMode(mode)
    }

    override fun setSign(sign: Sign) {
        model.setSign(sign)
    }

    override fun setNegative(negative: Int) {
        model.setNegative(negative)
    }

    override fun setSecond(second: Int) {
        model.setSecond(second)
    }

    override fun setData(data: String) {
        model.setData(data)
    }
}
