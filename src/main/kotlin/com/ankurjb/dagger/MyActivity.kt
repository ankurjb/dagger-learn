package com.ankurjb.dagger

import com.ankurjb.dagger.di.DaggerCarMyComponent
import com.ankurjb.dagger.models.Car
import javax.inject.Inject

class MyActivity {
    init {
        DaggerCarMyComponent.create().inject(this)
    }

    @Inject
    lateinit var car: Car

    fun onCreate() {
        car.getCarName()
    }
}
