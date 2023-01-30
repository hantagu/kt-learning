abstract class Carriage(
        manufacturer: String,
        model: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        val reducedEnginePower: Double,
        val capacity: Double,
        val cargoType: String): MovableEntity(manufacturer, model, trackWidth, weight, maxSpeed)
