abstract class Locomotive(
        manufacturer: String,
        model: String,
        trackWidth: Double,
        weight: Double,
        maxSpeed: Double,
        val type: String,
        val enginePower: Double,
        val powerReserve: Double?): MovableEntity(manufacturer, model, trackWidth, weight, maxSpeed)
