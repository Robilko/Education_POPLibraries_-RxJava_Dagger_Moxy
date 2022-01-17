package com.example.homework5.mvpuser

import com.example.homework5.data.GitHubRepo
import com.example.homework5.data.GitHubRepoRepository
import com.example.homework5.data.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.random.Random

class UserPresenter(private val userLogin: String) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var repoRepository: GitHubRepoRepository

    override fun onFirstViewAttach() {
        loadUser()
    }

    fun loadUser() {
        userRepository
            .getUserByLogin(userLogin)
            .doOnSubscribe { viewState.setProgressBarVisibility(true) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ user ->
                viewState.showUser(user)
            }, { error ->
                viewState.showError(error.message.toString())
            })

        repoRepository
            .getUserRepos(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { viewState.setProgressBarVisibility(false) }
            .subscribe({ repos ->
                viewState.showRepositories(repos)
//                throwTestErrors(repos)
            }, { error ->
                viewState.showError(error.message.toString())
            })
    }

    // Метод для рандомного прокидывания ошибки

//    private fun throwTestErrors(repos: List<GitHubRepo>) {
//        val rand = Random.nextInt(0, 3)
//        if (rand == 0) {
//            viewState.showError("Ошибка загрузки репозиториев")
//        } else {
//            viewState.showRepositories(repos)
//        }
//    }
}