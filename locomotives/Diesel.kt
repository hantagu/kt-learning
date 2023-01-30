package locomotives

import Locomotive

class Diesel(
        manufacturer: String,
        model: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        type: String,
        enginePower: Double,
        powerReserve: Double): Locomotive(manufacturer, model, trackWidth, weight, maxSpeed, type, enginePower, powerReserve)
