package com.example.homework5.mvpuser

import com.example.homework5.data.GitHubUserRepository
import com.example.homework5.navigation.CustomRouter
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            ?.let(viewState::showUser)
    }
}