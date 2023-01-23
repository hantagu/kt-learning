class Clothes(name: String, price: Double, inStock: Boolean, val size: String, val gender: String, val tryOn: Boolean) : Product(name, price, inStock)
{
    override fun toString(): String {
        return super.toString() + "\nРазмер: ${size}\nПол: ${gender}\nВозможность примерки: ${if (tryOn) "да" else "нет"}"
    }
}
