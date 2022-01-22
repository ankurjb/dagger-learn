package com.ankurjb.dagger.di

import com.ankurjb.dagger.models.Air
import com.ankurjb.dagger.models.TireTube
import com.ankurjb.dagger.models.Tires
import dagger.Module
import dagger.Provides

@Module
class TyresModule {

    @Provides
    fun providesTyreTube() = TireTube()

    @Provides
    fun providesAir() = Air()

    @Provides
    fun providesTyres(
        tyreTube: TireTube,
        air: Air
    ) = Tires(
        tyreTube,
        air
    )
}