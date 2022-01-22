package com.ankurjb.dagger.di

import com.ankurjb.dagger.MyActivity
import dagger.Component

@Component(modules = [TyresModule::class, PetrolEngineModule::class])
interface CarComponent {
    fun inject(myActivity: MyActivity)
}
