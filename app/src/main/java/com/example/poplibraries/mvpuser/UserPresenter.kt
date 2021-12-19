package com.example.poplibraries.mvpuser

import com.example.poplibraries.data.UserData
import moxy.MvpPresenter

class UserPresenter(
    private val user: UserData?
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        user?.let {
            viewState.setUserLogin(it.login)
        }
    }
}