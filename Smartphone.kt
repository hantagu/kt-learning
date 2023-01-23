class Smartphone(name: String, price: Double, inStock: Boolean, val cameraMP: String, val processorModel: String, val display: String) : Product(name, price, inStock)
{
    override fun toString(): String {
        return super.toString() + "\nКамера: $cameraMP\nПроцессор: $processorModel\nДисплей: $display"
    }
}
