abstract class Product(val name: String, val price: Double, var inStock: Boolean)
{
    companion object {
        private var staticArticul: Int = 0
    }

    var articul: Int = 0
        private set

    var rating: Int = 0
        private set

    init {
        staticArticul++
        articul = staticArticul
    }

    fun setMark(rate: Int) {
        if (rate in 1..5) {
            rating = rate
        }
    }

    override fun toString(): String = "Название: $name\nАртикул: $articul\nЦена: $price\nНаличие на складе: $inStock"
}
