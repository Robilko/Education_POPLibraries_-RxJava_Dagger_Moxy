package com.example.poplibraries.navigation

import com.example.poplibraries.data.UserData
import com.example.poplibraries.mvplogin.LoginFragment
import com.example.poplibraries.mvpuser.UserFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun login() = FragmentScreen { LoginFragment.newInstance() }
    override fun main(user: UserData): Screen = FragmentScreen { UserFragment.newInstance(user) }
}