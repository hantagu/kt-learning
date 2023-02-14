import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.math.exp
import kotlin.random.Random
import kotlin.system.exitProcess

fun main()
{
    val rnd = Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))

    println("Матрицы:")
    print("\tКоличество строк: ")
    val rows = readln().toInt()

    print("\tКоличество столбцов: ")
    val columns = readln().toInt()

    print("\tМножитель матриц (дробное число): ")
    val coefficient = readln().toDouble()

    print("\tСтепень, в которую будет возведены матрицы (целое число): ")
    val exponent = readln().toInt()

    println()

    println("Диапазон генерации случайных значений")
    print("\tНижняя граница (включительно): ")
    val low = readln().toDouble()

    print("\tВерхняя граница (не включительно): ")
    val high = readln().toDouble()

    println()

    if (low >= high) {
        println("Нижняя граница выше чем верхняя: [$low ; $high)")
        exitProcess(1)
    }

    val a = Matrix(rows, columns) { _, _ -> rnd.nextDouble(low, high) }
    val b = Matrix(rows, columns) { _, _ -> rnd.nextDouble(low, high) }

    println("Матрица #1:\n$a\n")
    println("Матрица #2:\n$b\n")

    println("Сумма двух матриц:")
    try {
        println("${a + b}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Разница двух матриц:")
    try {
        println("${a - b}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Произведение матрицы #1 и $coefficient:\n${a * coefficient}\n")
    println("Произведение матрицы #2 и $coefficient:\n${b * coefficient}\n")

    println("Произведение двух матриц:")
    try {
        println("${a * b}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Матрица #1 в степени $exponent:")
    try {
        println("${a pow exponent}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Матрица #2 в степени $exponent:")
    try {
        println("${b pow exponent}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Определитель матрицы #1:")
    try {
        println("${a.determinant()}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Определитель матрицы #2:")
    try {
        println("${b.determinant()}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Обратная матрица для матрицы #1:")
    try {
        println("${a.inverse()}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }

    println("Обратная матрица для матрицы #2:")
    try {
        println("${b.inverse()}\n")
    } catch (e: IllegalArgumentException) {
        println("${e.message}\n")
    }
}
