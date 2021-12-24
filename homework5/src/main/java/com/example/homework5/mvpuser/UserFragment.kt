package com.example.homework5.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework5.App.Navigation.router
import com.example.homework5.R
import com.example.homework5.data.GitHubUser
import com.example.homework5.data.GitHubUserRepositoryFactory
import com.example.homework5.databinding.ViewUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(R.layout.view_user), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        viewBinding.userLogin.text = userLogin
    }

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.login
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}
