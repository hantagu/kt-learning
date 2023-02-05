package carriages

import Carriage

class Freight(
        manufacturer: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double): Carriage(manufacturer, trackWidth, weight, maxSpeed, reducedEnginePower)
