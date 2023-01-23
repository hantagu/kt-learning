class Deer(name: String, height: Double, weight: Double, habitat: String): Herbivore()
{
    override val kind: String = "Олень"
    override val name: String = name
    override val height: Double = height
    override val weight: Double = weight
    override val habitat: String = habitat

    fun hide() {
        println("$kind $name спрятался от хищника")
    }

    fun seekMoss() {
        println("$kind $name ищет мох")
    }
}
