package com.example.homework5.dagger

import android.content.Context
import com.example.homework5.MainActivity
import com.example.homework5.mvpuser.UserPresenter
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
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)
    fun inject(activity: UserPresenter)

}
