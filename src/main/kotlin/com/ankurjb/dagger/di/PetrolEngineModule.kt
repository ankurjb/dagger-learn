package com.ankurjb.dagger.di

import com.ankurjb.dagger.models.Engine
import com.ankurjb.dagger.models.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    /**
     *  Using Provides increases code when we are dealing with interface
     *  to resolve this we can directly use Binds instead on Provides
     *  to reduce boilerplate code
     *
     *  @Provides
     *  fun providesPetrolEngine(petrolEngine: PetrolEngine): Engine = petrolEngine
     */

    @Binds
    abstract fun bindsPetrolEngine(petrolEngine: PetrolEngine): Engine
}
