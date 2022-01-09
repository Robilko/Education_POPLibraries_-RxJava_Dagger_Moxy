package com.example.homework5

import android.app.Application
import com.example.homework5.dagger.AppComponent
import com.example.homework5.dagger.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}