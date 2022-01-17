package com.example.homework5.dagger

import com.example.homework5.data.GitHubRepoRepository
import com.example.homework5.data.GitHubRepoRepositoryImpl
import com.example.homework5.data.GitHubUserRepository
import com.example.homework5.data.GitHubUserRepositoryImpl
import com.example.homework5.data.retrofit.GitHubApi
import com.example.homework5.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    fun provideUserRepository(
        @Named("prod") api: GitHubApi,
        dbStorage: DBStorage
    ): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage)
    }

    @Provides
    fun provideRepoRepository(
        @Named("prod") api: GitHubApi,
        dbStorage: DBStorage
    ): GitHubRepoRepository {
        return GitHubRepoRepositoryImpl(api, dbStorage)
    }
}