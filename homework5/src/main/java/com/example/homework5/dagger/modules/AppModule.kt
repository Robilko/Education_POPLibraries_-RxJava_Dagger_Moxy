package com.example.homework5.dagger.modules

import com.example.homework5.dagger.components.UserComponent
import dagger.Module

@Module (subcomponents = [UserComponent::class])
class AppModule