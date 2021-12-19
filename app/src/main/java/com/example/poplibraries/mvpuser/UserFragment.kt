package com.example.poplibraries.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poplibraries.data.UserData
import com.example.poplibraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment() : MvpAppCompatFragment(), UserView {

    companion object {
        private const val USER_DATA = "user_data"

        fun newInstance(user: UserData) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_DATA, user)
            }
        }
    }

    private val user: UserData? by lazy {
        arguments?.getParcelable(USER_DATA)
    }
    private val presenter: UserPresenter by moxyPresenter { UserPresenter(user) }
    private lateinit var vb: FragmentUserBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun setUserLogin(login: String) {
        vb.mainTextView.text = login
    }
}