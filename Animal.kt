abstract class Animal
{
    abstract val kind: String
    abstract val name: String
    abstract val height: Double
    abstract val weight: Double
    abstract val habitat: String

    abstract fun eat()

    fun sleep() {
        println("$kind $name спит")
    }

    fun walk() {
        println("$kind $name идёт")
    }
}
