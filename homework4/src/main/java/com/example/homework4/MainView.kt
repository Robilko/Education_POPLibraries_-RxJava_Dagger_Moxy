package com.example.homework4

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType (AddToEndStrategy::class)
interface MainView : MvpView {
    fun setCalculateResult(result: Long)
    fun showError(message: String)
}