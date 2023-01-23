class Grocery(name: String, price: Double, inStock: Boolean, val expirationDate: String, val calories: Int, val ingredients: List<String>) : Product(name, price, inStock)
{
    override fun toString(): String {
        return super.toString() + "\nСрок годности: до $expirationDate\nКалорийность: $calories\nСостав: ${ingredients.joinToString(", ")}"
    }
}
