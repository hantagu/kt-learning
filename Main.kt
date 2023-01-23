val p = mutableListOf<Product>()

fun main()
{
    while (true)
    {
        print("0 - добавить товар, 1 - вывести информацию о товаре по артикулу: ")
        when (readln())
        {
            "0" -> addProduct()
            "1" -> {
                print("Артикул: ")
                findByArticul(readln().toInt())
            }
        }
    }
}

fun addProduct()
{
    print("\nНазвание: ")
    val name = readln()

    print("Цена: ")
    val price = readln().toDouble()

    print("В наличии? (да/нет): ")
    val inStock = readln() == "да"

    print("\n0 - продукт, 1 - одежда, 2 - телефон: ")

    when (readln()) {
        "0" -> addGrocery(name, price, inStock)
        "1" -> addClothes(name, price, inStock)
        "2" -> addSmartphone(name, price, inStock)
    }
}

fun addGrocery(name: String, price: Double, inStock: Boolean)
{
    print("Срок годности: до ")
    val exparationDate = readln()

    print("Калорийность: ")
    val calories = readln().toInt()

    print("Состав (через \", \"): ")
    val ingridients = readln().split(", ")

    val gx = Grocery(name, price, inStock, exparationDate, calories, ingridients)
    p.add(gx)
    println("Его артикул: ${gx.articul}\n")
}

fun addClothes(name: String, price: Double, inStock: Boolean)
{
    print("Размер: ")
    val size = readln()

    print("Пол: ")
    val gender = readln()

    print("Возможность примерки: ")
    val tryOn = readln() == "да"

    val cx = Clothes(name, price, inStock, size, gender, tryOn)
    p.add(cx)
    println("Его артикул: ${cx.articul}\n")
}

fun addSmartphone(name: String, price: Double, inStock: Boolean)
{
    print("Камера: ")
    val cam = readln()

    print("Процессор: ")
    val cpu = readln()

    print("Дисплей: ")
    val display = readln()

    val sx = Smartphone(name, price, inStock, cam, cpu, display)
    p.add(sx)
    println("Его артикул: ${sx.articul}\n")
}

fun findByArticul(x: Int)
{
    println(p.find { it.articul == x } ?: "не найдено")
    println()
}
