
package com.example.poplibraries

import android.os.Bundle
import com.example.poplibraries.application.App
import com.example.poplibraries.databinding.ActivityMainBinding
import com.example.poplibraries.mvpmain.MainPresenter
import com.example.poplibraries.navigation.AndroidScreens
import com.example.poplibraries.mvpmain.MainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class StartActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

}