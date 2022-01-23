package com.ankurjb.dagger.models

import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels,
    private val driver: Driver
) {
    val carName = "lamborghini"

    fun drive() {
        println(engine.getEngine())
        println(wheels.tires.tireTube.quality)
        println(wheels.tires.air.quality)
        println(wheels.getWheels())
        println("${driver.hashCode()} is driving")
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

/**
 * To create a Singleton instance of an object we need to annotate the class as Singleton and
 * also annotate the component as singleton
 *
 * But if we follow this approach the scope of the singleton object remains
 * same as that of the component
 *
 * So if you create a new component or else your activity goes through orientation change
 * again component will be created and singleton will be created again.
 *
 */
@Singleton
class Driver @Inject constructor()

interface Engine {
    fun getEngine(): String
}

class PetrolEngine @Inject constructor(
    @Named("horse power") private val horsePower: Int,
    @Named("tank capacity") private val tankCapacity: Int
) : Engine {
    override fun getEngine() = "petrol engine started with $horsePower horsePower and $tankCapacity capacity"
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
