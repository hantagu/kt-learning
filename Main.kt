fun main()
{
    println("Машина:")

    print("\tПроизводитель: ")
    val carManufacturer = readln()

    print("\tМодель: ")
    val carModel = readln()

    print("\tМасса: ")
    val carWeight = readln().toDouble()

    println()

    println("Двигатель:")

    print("\tПроизводитель: ")
    val engineManufacturer = readln()

    print("\tМасса: ")
    val engineWeight = readln().toDouble()

    print("\tМощность: ")
    val enginePower = readln().toDouble()

    println()

    print("Прицеп (да/нет): ")
    val hasTrailer = readln() == "да"

    var trailer: Trailer? = null

    if (hasTrailer)
    {
        print("\tПроизводитель: ")
        val trailerManufacturer = readln()

        print("\tМасса: ")
        val trailerWeight = readln().toDouble()

        print("\tМаксимальная вместимость: ")
        val trailerMaxCapacity = readln().toDouble()

        trailer = Trailer(trailerManufacturer, trailerWeight, trailerMaxCapacity)
    }

    println()

    val engine = Engine(engineManufacturer, engineWeight, enginePower)
    val car = Car(carManufacturer, carModel, carWeight, engine, trailer)

    while (true)
    {
        println("1. Добавить груз в прицеп (${trailer?.manufacturer ?: "прицеп отсутствует"})")
        println("2. Добавить прицеп")
        println("3. Убрать прицеп")
        println("4. Вывод данных о машине")

        print("> ")
        when (readln())
        {
            "1" -> {
                if (trailer === null) {
                    println("Прицеп отсутствует")
                    continue
                }

                print("Масса груза: ")
                trailer += readln().toDouble()
                println()
            }

            "2" -> {
                if (trailer !== null) {
                    car.attachTrailer(trailer)
                    println("Прицеп добавлен\n")
                } else {
                    println("Прицеп отсутствует\n")
                }
            }

            "3" -> {
                if (car.trailer !== null) {
                    car.detachTrailer()
                    println("Прицеп убран\n")
                } else {
                    println("Прицеп уже был убран раньше\n")
                }
            }

            "4" -> {
                print(car)
            }

            else -> continue
        }
    }
}
