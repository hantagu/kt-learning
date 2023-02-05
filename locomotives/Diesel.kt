package locomotives

import Locomotive

class Diesel(
        manufacturer: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double): Locomotive(manufacturer, trackWidth, weight, maxSpeed, reducedEnginePower)
