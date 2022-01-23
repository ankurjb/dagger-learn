package com.ankurjb.dagger

import com.ankurjb.dagger.di.DaggerCarComponent
import com.ankurjb.dagger.models.Car
import javax.inject.Inject

class MyActivity {
    init {
        /**
         * Now since we need to pass runtime dependency horsePower to the module we can't directly use
         * DaggerComponent.create()
         *
         * We need to use builder now.
         *      DaggerCarComponent
         *          .builder()
         *          .dieselEngineModule(DieselEngineModule(500))
         *          .build()
         *          .inject(this)
         */
        DaggerCarComponent
            .builder()
            .horsePower(670)
            .tankCapacity(56)
            .build()
            .inject(this)
    }

    @Inject
    lateinit var car: Car

    @Inject
    lateinit var car2: Car

    fun onCreate() {
        car.drive()
        car2.drive()
    }
}
