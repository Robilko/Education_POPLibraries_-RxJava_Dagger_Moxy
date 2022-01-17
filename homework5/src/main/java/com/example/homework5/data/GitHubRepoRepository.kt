package com.example.homework5.data

import io.reactivex.rxjava3.core.Single

interface GitHubRepoRepository {

    fun getUserRepos(login: String): Single<List<GitHubRepo>>
}