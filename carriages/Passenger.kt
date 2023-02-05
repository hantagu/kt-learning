package carriages

import Carriage

class Passenger(
        manufacturer: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double): Carriage(manufacturer, trackWidth, weight, maxSpeed, reducedEnginePower)
