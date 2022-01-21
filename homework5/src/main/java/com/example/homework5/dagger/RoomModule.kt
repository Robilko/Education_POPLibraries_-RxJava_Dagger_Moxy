package com.example.homework5.dagger

import android.content.Context
import androidx.room.Room
import com.example.homework5.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomModule(app: Context): DBStorage {
        return Room.databaseBuilder(app, DBStorage::class.java, "github.db")
            .build()
    }
}