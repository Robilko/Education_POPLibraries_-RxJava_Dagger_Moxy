package com.example.homework5.dagger.components

import com.example.homework5.dagger.modules.RepoRepositoryModule
import com.example.homework5.mvpuser.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@UserFragmentScope
@Subcomponent (modules = [RepoRepositoryModule::class])
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }

    fun inject(activity: UserPresenter)
}

@Scope
annotation class UserFragmentScope