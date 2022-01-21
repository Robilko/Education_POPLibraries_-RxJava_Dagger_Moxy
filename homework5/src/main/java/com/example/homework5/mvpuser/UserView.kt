package com.example.homework5.mvpuser

import com.example.homework5.data.GitHubRepo
import com.example.homework5.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

@StateStrategyType(SingleStateStrategy::class)
interface UserView : MvpView {

    fun showUser(user: GitHubUser)
    fun showError(message: String)
    fun showRepositories(repositories: List<GitHubRepo>)

}
