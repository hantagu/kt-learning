package locomotives

import Locomotive

class Electric(
        manufacturer: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double): Locomotive(manufacturer, trackWidth, weight, maxSpeed, reducedEnginePower)
