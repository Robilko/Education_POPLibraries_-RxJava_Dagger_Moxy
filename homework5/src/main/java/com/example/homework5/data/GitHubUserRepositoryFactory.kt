package com.example.homework5.data

object GitHubUserRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}