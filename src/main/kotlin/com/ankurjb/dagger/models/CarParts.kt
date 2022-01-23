package com.ankurjb.dagger.models

import javax.inject.Inject

class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels
) {
    val carName = "lamborghini"

    fun drive() {
        println(engine.getEngine())
        println(wheels.tires.tireTube.quality)
        println(wheels.tires.air.quality)
        println(wheels.getWheels())
    }


    /**
     * We need to add Inject on function because it requires a Remote object which needs to be injected
     *
     * Since constructor of Car is injected we don't need to manually inject remote using dagger
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

interface Engine {
    fun getEngine(): String
}

class PetrolEngine @Inject constructor() : Engine {
    override fun getEngine() = "petrol engine started"
}

class DieselEngine @Inject constructor(
    private val horsePower: Int
) : Engine {
    override fun getEngine() = "diesel engine started with $horsePower horsePower"
}

class Wheels @Inject constructor(
    val tires: Tires
) {
    fun getWheels() = "wheels rolling"
}

class Remote @Inject constructor() {
    fun attachRemote(car: Car) {
        println("remote added to ${car.carName}")
    }
}
