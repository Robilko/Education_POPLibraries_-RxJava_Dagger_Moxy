package com.example.poplibraries.navigation

import com.example.poplibraries.data.UserData
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun login(): Screen
    fun main(user: UserData): Screen
}