package com.example.homework5.mvpuser

import com.example.homework5.data.GitHubUserRepository
import com.example.homework5.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                viewState.showUser(user)
            }, { error ->
                viewState.showError(error.message.toString())
            })
    }
}