package carriages

import Carriage

class Passenger(
        manufacturer: String,
        model: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        reducedEnginePower: Double,
        capacity: Double,
        cargoType: String): Carriage(manufacturer, model, trackWidth, weight, maxSpeed, reducedEnginePower, capacity, cargoType)
