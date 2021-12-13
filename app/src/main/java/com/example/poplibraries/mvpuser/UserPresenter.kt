package com.example.poplibraries.mvpuser

import com.example.poplibraries.data.UserData
import moxy.MvpPresenter

class UserPresenter(
    private val user: UserData
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        viewState.setUserLogin(user.login)
    }

    fun init() {}

}