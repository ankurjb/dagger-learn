package com.ankurjb.dagger.di

import com.ankurjb.dagger.MyActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [TyresModule::class, PetrolEngineModule::class])
interface CarComponent {
    fun inject(myActivity: MyActivity)

    @Component.Builder
    interface Builder {
        /**
         * Instead of creating instances for our Modules in our injection site
         * we can override dagger builder and provide compile time dependencies like this
         *
         * This can also help us provide multiple dependencies of same type using @Named
         */

        @BindsInstance
        fun horsePower(@Named("horse power") horsePower: Int): Builder

        @BindsInstance
        fun tankCapacity(@Named("tank capacity") tankCapacity: Int): Builder

        fun build(): CarComponent
    }
}
