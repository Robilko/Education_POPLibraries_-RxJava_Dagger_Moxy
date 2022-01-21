package com.example.homework5.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework5.data.GitHubUser
import com.example.homework5.databinding.ViewUserBinding

class UserViewHolder(private val viewBinding: ViewUserBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(user: GitHubUser, onUserClickListener: UsersAdapter.OnUserClickListener?) {
        viewBinding.userLogin.text = user.login

        Glide.with(viewBinding.userAvatar.context)
            .load(user.avatarUrl)
            .into(viewBinding.userAvatar)

        viewBinding.root.setOnClickListener {
            onUserClickListener?.onUserPicked(user)
        }
    }
}