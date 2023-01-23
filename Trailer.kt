class Trailer(val manufacturer: String, val weight: Double, val maxCapacity: Double)
{
    var currentCapacity = 0.0
        private set

    val loadPercentage
        get() = this.currentCapacity / this.maxCapacity * 100

    val totalWeight
        get() = this.weight + this.currentCapacity

    operator fun plusAssign(weight: Double)
    {
        if (this.currentCapacity + weight <= this.maxCapacity)
            this.currentCapacity += weight
    }

    override fun toString(): String
    {
        val stringBuilder = StringBuilder()

        stringBuilder.append("\tПроизводитель: $manufacturer\n")
        stringBuilder.append("\tМаксимальная вместимость: $maxCapacity\n")
        stringBuilder.append("\tМасса: $weight (прицеп) + $currentCapacity (груз) = $totalWeight (итого)\n")
        stringBuilder.append("\tЗагружен на $loadPercentage%")

        return stringBuilder.toString()
    }
}
