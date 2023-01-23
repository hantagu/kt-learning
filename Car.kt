class Car(val manufacturer: String, val model: String, val weight: Double, val engine: Engine, trailer: Trailer? = null)
{
    var trailer: Trailer? = trailer
        private set

    val maxSpeed: Double
        get() = this.engine.power / (this.totalWeight * 9.8)

    val totalWeight
        get() = this.weight + this.engine.weight + (this.trailer?.totalWeight ?: 0.0)

    fun attachTrailer(t: Trailer)
    {
        this.trailer = t
    }

    fun detachTrailer()
    {
        this.trailer = null
    }

    override fun toString(): String
    {
        val stringBuilder = StringBuilder()

        stringBuilder.append("Машина:\n")
        stringBuilder.append("\tПроизводитель: $manufacturer\n")
        stringBuilder.append("\tМодель: $model\n")
        stringBuilder.append("\tМакс. скорость: $maxSpeed\n")
        stringBuilder.append("\tУдельная мощность двигателя: ${engine.specificPower(weight, trailer?.weight ?: 0.0)}\n\n")

        stringBuilder.append("Прицеп:\n")
        stringBuilder.append("${trailer ?: "\tНет"}\n\n")

        stringBuilder.append("Двигатель:\n")
        stringBuilder.append("$engine\n\n")

        return stringBuilder.toString()
    }
}
