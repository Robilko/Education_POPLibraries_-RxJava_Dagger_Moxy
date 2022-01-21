package com.example.homework5.dagger.components

import android.content.Context
import com.example.homework5.MainActivity
import com.example.homework5.dagger.modules.*
import com.example.homework5.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        UserRepositoryModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    fun provideUserComponent(): UserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)

}
