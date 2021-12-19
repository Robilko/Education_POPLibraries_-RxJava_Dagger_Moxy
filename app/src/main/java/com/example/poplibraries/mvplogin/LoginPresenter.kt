package com.example.poplibraries.mvplogin

import com.example.poplibraries.data.UserData
import com.example.poplibraries.navigation.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class LoginPresenter(private val router: Router, private val screens: IScreens) :
    MvpPresenter<LoginView>() {

    private fun checkLoginIsValid(login: String) : Boolean {
        return login.isNotEmpty().also {
            if (!it) {
                viewState.showErrorMessage("Login is empty")
            }
        }
    }

    private fun checkPasswordIsValid(password: String) : Boolean {
        return password.isNotEmpty().also {
            if (!it) {
                viewState.showErrorMessage("Password is empty")
            }
        }
    }

    fun loginClick(userData: UserData) {
        if (checkLoginIsValid(userData.login) && checkPasswordIsValid(userData.password)) {
            router.navigateTo(screens.main(userData))
        }
    }
}