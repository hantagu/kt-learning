class RollingStock(var head: Locomotive, val tail: MutableList<Carriage> = mutableListOf())
{
    fun addCarrige(c: Carriage): Boolean
    {
        if (c.trackWidth != head.trackWidth)
            return false

        tail.add(c)
        return true
    }

    fun removeCarrigeByNumber(n: Int) {
        tail.removeAt(n)
    }
}
