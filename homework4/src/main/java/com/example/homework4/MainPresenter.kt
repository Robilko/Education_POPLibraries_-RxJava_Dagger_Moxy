package com.example.homework4

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.ReplaySubject
import moxy.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {

    private val subject: ReplaySubject<Long> = ReplaySubject.create()
    private val observerResult: Observable<Long> = subject
        .map { number -> number * number }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCalculateResult(0)
    }

    fun subscribe() {
        observerResult.subscribe { viewState.setCalculateResult(it) }
    }

    fun calculate(number: String?) {
        number?.let {
            subject.onNext(number.toLong())
        } ?: viewState.showError("Поле не может быть пустым. \nВведите число.")
    }


}