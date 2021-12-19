package com.example.poplibraries.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(var login: String, var password: String) : Parcelable