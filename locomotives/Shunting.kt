package locomotives

import Locomotive

class Shunting(
        manufacturer: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double): Locomotive(manufacturer, trackWidth, weight, maxSpeed, reducedEnginePower)
