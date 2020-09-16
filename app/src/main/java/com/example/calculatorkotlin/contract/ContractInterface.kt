package com.example.calculatorkotlin.contract

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun update()
        fun getData(): String
    }

    interface Model {
        fun getData(): Int
        fun update()
    }

}