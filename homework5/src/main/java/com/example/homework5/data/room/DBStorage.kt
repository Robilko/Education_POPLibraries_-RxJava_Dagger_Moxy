package com.example.homework5.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework5.data.GitHubRepo
import com.example.homework5.data.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepo::class], version = 1)
abstract class DBStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao

    abstract fun getGitHubRepoDao(): GitHubRepoDao
}