package com.example.poplibraries.mvplogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.poplibraries.application.App
import com.example.poplibraries.databinding.FragmentLoginBinding
import com.example.poplibraries.data.UserData
import com.example.poplibraries.navigation.AndroidScreens
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(), LoginView {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val presenter: LoginPresenter by moxyPresenter {
        LoginPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }
    private lateinit var vb: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentLoginBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb.loginBtn.setOnClickListener {
            presenter.loginClick(UserData(vb.login.text.toString(), vb.password.text.toString()))
        }
    }

    override fun showErrorMessage(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }
}