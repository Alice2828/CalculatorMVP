package com.example.calculatorkotlin.model


import com.example.calculatorkotlin.contract.ContractInterface

class ModelActivity : ContractInterface.Model {

    private var mCounter = 0

    override fun getData()= mCounter

    override fun update() {
        mCounter++
    }
}
