package com.ankurjb.dagger.models

import javax.inject.Inject

class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels
) {
    fun getCarName() {
        println("lamborghini")
        println(engine.getEngine())
        println(wheels.getWheels())
    }
}

class Engine @Inject constructor() {
    fun getEngine() = "engine started"
}

class Wheels @Inject constructor() {
    fun getWheels() = "wheels rolling"
}
