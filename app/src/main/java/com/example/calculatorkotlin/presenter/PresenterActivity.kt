package com.example.calculatorkotlin.presenter

import com.example.calculatorkotlin.contract.ContractInterface
import com.example.calculatorkotlin.model.ModelActivity

class PresenterActivity(_view: ContractInterface.View): ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = ModelActivity()

    init {
        view.initView()
    }

    override fun update() {
        model.update()
        view.updateViewData()
    }

    override fun getData() = model.getData().toString()
}
