package com.example.homework5.mvpusers

import com.example.homework5.data.GitHubUserRepository
import com.example.homework5.mvpuser.UserScreen
import com.example.homework5.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(login: String) {
        router.navigateTo(UserScreen(login))
    }

    fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            }, {
                val errorMessage = it.message
                //DisplayError
            })
    }
}
