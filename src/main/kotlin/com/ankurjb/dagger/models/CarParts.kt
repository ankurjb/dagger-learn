package com.ankurjb.dagger.models

import javax.inject.Inject

class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels
) {
    fun drive() {
        println(engine.getEngine())
        println(wheels.getWheels())
    }

    fun getCarName() = "lamborghini"


    /**
     * We need to add Inject on function because it requires a Remote object which needs to be injected
     *
     * Since constructor or Car is injected we don't need to manually inject remote using dagger
     * by using DaggerComponent.create() like we did in our Activity
     *
     * Order will be like
     * 1) constructor injection
     * 2) field injection
     * 3) method injection
     */
    @Inject
    fun addRemote(remote: Remote) {
        remote.attachRemote(this)
    }
}

class Engine @Inject constructor() {
    fun getEngine() = "engine started"
}

class Wheels @Inject constructor() {
    fun getWheels() = "wheels rolling"
}

class Remote @Inject constructor() {
    fun attachRemote(car: Car) {
        println("remote added to ${car.getCarName()}")
    }
}
