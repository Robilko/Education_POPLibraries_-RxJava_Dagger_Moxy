package com.example.poplibraries.mvplogin

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface LoginView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showErrorMessage(errorMessage: String)
}