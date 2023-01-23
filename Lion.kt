class Lion(name: String, height: Double, weight: Double, habitat: String) : Predator()
{
    override val kind = "Лев"
    override val name = name
    override val height = height
    override val weight = weight
    override val habitat = habitat

    fun growl() {
        println("$kind $name рычит")
    }

    fun run() {
        println("$kind $name бежит за добычей")
    }
}
