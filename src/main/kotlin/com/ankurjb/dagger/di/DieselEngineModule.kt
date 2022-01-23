package com.ankurjb.dagger.di

import com.ankurjb.dagger.models.DieselEngine
import com.ankurjb.dagger.models.Engine
import dagger.Module
import dagger.Provides

@Module
class DieselEngineModule(
    private val horsePower: Int
) {

    /**
     *  Diesel engine needs a dependency *horsePower* which will be available at run time
     *  than compile time.
     *
     *  To provide such dependencies we can follow this pattern
     */

    @Provides
    fun providesDieselEngine(): Engine = DieselEngine(horsePower)
}
