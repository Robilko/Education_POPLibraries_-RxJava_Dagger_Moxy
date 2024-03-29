package com.example.poplibraries.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType (AddToEndSingleStrategy::class)
interface UserView: MvpView {
    fun setUserLogin(login: String)
}