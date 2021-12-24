package com.example.homework5.data

import com.example.homework5.data.retrofit.GitHubApiFactory
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsers(): Single<List<GitHubUser>> {
        return gitHubApi.fetchUsers()
    }

    override fun getUserByLogin(userId: String): GitHubUser? {
        return null
    }
}