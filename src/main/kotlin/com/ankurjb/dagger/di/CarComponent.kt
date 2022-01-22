package com.ankurjb.dagger.di

import com.ankurjb.dagger.MyActivity
import com.ankurjb.dagger.models.Car
import dagger.Component

@Component
interface CarMyComponent {
    fun provides(): Car
    fun inject(myActivity: MyActivity)
}
