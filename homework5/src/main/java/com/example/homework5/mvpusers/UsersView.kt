package com.example.homework5.mvpusers

import com.example.homework5.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUser>)

}
