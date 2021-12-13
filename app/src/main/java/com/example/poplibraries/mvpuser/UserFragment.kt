package com.example.poplibraries.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poplibraries.data.UserData
import com.example.poplibraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(private val user: UserData) : MvpAppCompatFragment(), UserView {

    companion object {
        fun newInstance(user: UserData) = UserFragment(user)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.init()
        retainInstance = true //временное решение, чтобы пережить переворот экрана в этом фрагменте
    }

    override fun setUserLogin(login: String) {
        vb.mainTextView.text = login
    }
}