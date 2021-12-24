package com.example.homework5

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.App.Navigation.navigatorHolder
import com.example.homework5.App.Navigation.router
import com.example.homework5.mvpusers.UsersScreen
import com.example.homework5.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}