class Engine(val manufacturer: String, val weight: Double, val power: Double)
{
    fun specificPower(carWeight: Double, trailerWeight: Double) = (carWeight + this.weight + trailerWeight) / this.power

    override fun toString() = "\tПроизводитель: $manufacturer\n\tМощность: $power\n\tМасса: $weight"
}
