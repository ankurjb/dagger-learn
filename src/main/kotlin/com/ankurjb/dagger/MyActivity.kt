package com.ankurjb.dagger

import com.ankurjb.dagger.di.DaggerCarComponent
import com.ankurjb.dagger.models.Car
import javax.inject.Inject

class MyActivity {
    init {
        DaggerCarComponent.create().inject(this)
    }

    @Inject
    lateinit var car: Car

    fun onCreate() {
        car.drive()
    }
}
