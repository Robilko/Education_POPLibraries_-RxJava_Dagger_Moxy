package com.example.homework5.dagger.modules

import com.example.homework5.dagger.components.UserFragmentScope
import com.example.homework5.data.GitHubRepoRepository
import com.example.homework5.data.GitHubRepoRepositoryImpl
import com.example.homework5.data.retrofit.GitHubApi
import com.example.homework5.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepoRepositoryModule {

    @UserFragmentScope
    @Provides
    fun provideRepoRepository(
        @Named("prod") api: GitHubApi,
        dbStorage: DBStorage
    ): GitHubRepoRepository {
        return GitHubRepoRepositoryImpl(api, dbStorage)
    }
}