package com.ankurjb.dagger.models


/**
 * Third party classes, we can't inject the constructors
 */
class Tires constructor(
    val tireTube: TireTube,
    val air: Air
)

class TireTube {
    val quality = "BEST tyre tube"
}

class Air {
    val quality = "air full"
}
