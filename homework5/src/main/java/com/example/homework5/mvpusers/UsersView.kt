package com.example.homework5.mvpusers

import com.example.homework5.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface UsersView : MvpView {

    fun showUsers(users: List<GitHubUser>)
    fun showError(message: String)

}
