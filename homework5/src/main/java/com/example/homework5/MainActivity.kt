package com.example.homework5

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.mvpusers.UsersScreen
import com.example.homework5.navigation.CustomNavigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)

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