import java.util.*
import kotlin.math.abs

class Matrix(val rows: Int, val columns: Int)
{
    private val elements = MutableList(rows * columns) { 0.0 }


    constructor(rows: Int, columns: Int, generator: (row: Int, column: Int) -> Double) : this(rows, columns) {
        for (i in elements.indices)
            elements[i] = generator(i % columns, i / rows)
    }

    private constructor(rows: Int, columns: Int, generator: (index: Int) -> Double) : this(rows, columns) {
        for (i in elements.indices)
            elements[i] = generator(i)
    }


    operator fun get(row: Int, column: Int) = elements[row * columns + column]

    operator fun set(row: Int, column: Int, value: Double) {
        elements[row * columns + column] = value
    }


    operator fun plus(other: Matrix): Matrix
    {
        if (!(rows == other.rows && columns == other.columns))
            throw IllegalArgumentException("Складывать допускается только матрицы одинаковой размерности")

        return Matrix(rows, columns) { i -> elements[i] + other.elements[i] }
    }

    operator fun minus(other: Matrix): Matrix
    {
        if (!(rows == other.rows && columns == other.columns))
            throw IllegalArgumentException("Вычитать допускается только матрицы одинаковой размерности")

        return Matrix(rows, columns) { i -> elements[i] - other.elements[i] }
    }


    operator fun times(other: Double) = Matrix(rows, columns) { i -> elements[i] * other }

    operator fun times(other: Matrix): Matrix
    {
        if (columns != other.rows)
            throw IllegalArgumentException("Умножать две матрицы допускается только в том случае, если число столбцов первой матрицы равняется числу строк второй матрицы")

        val result = Matrix(rows, other.columns)

        for (i in 0 until rows)
        {
            for (j in 0 until other.columns)
            {
                var sum = 0.0
                for (k in 0 until columns)
                    sum += elements[i * columns + k] * other.elements[k * other.columns + j]
                result.elements[i * result.columns + j] = sum
            }
        }

        return result
    }


    infix fun pow(exponent: Int): Matrix
    {
        if (rows != columns)
            throw IllegalArgumentException("Матрица не квадратная, нельзя возвести в степень")

        if (exponent < 0)
            throw IllegalArgumentException("Отрицательная степень не поддерживается")

        var result = Matrix(rows, columns) { r, c -> if (r == c) 1.0 else 0.0 }

        for (i in 0 until exponent)
            result *= this

        return result
    }


    private fun minor(rowToRemove: Int, columnToRemove: Int): Matrix
    {
        val minor = Matrix(rows - 1, columns - 1)

        var minorIndex = 0
        for (i in 0 until rows)
        {
            for (j in 0 until columns)
            {
                if (i != rowToRemove && j != columnToRemove)
                {
                    minor.elements[minorIndex] = elements[i * columns + j]
                    minorIndex++
                }
            }
        }

        return minor
    }


    fun determinant(): Double
    {
        if (rows != columns)
            throw IllegalArgumentException("Матрица не квадратная")

        if (rows == 1)
            return elements[0]

        if (rows == 2)
            return elements[0] * elements[3] - elements[1] * elements[2]

        var det = 0.0
        for (i in 0 until columns)
        {
            val minor = minor(0, i)
            det += if (i % 2 == 0) elements[i] * minor.determinant() else -elements[i] * minor.determinant()
        }

        return det
    }


    fun inverse(): Matrix
    {
        if (rows != columns)
            throw IllegalArgumentException("Матрица не квадратная")

        val identity = Matrix(rows, columns) { r, c -> if (r == c) 1.0 else 0.0 }

        val augmentedMatrix = Matrix(rows, columns * 2)
        for (i in 0 until rows)
        {
            for (j in 0 until columns)
                augmentedMatrix.elements[i * columns * 2 + j] = elements[i * columns + j]

            for (j in 0 until columns)
                augmentedMatrix.elements[i * columns * 2 + columns + j] = identity.elements[i * columns + j]
        }

        for (i in 0 until rows)
        {
            var maxRowIndex = i

            for (j in i + 1 until rows)
                if (abs(augmentedMatrix.elements[j * columns * 2 + i]) > abs(augmentedMatrix.elements[maxRowIndex * columns * 2 + i]))
                    maxRowIndex = j

            if (augmentedMatrix.elements[maxRowIndex * columns * 2 + i] == 0.0)
                throw IllegalArgumentException("Обратной матрицы не существует")

            if (maxRowIndex != i)
                for (j in 0 until columns * 2)
                {
                    val temp = augmentedMatrix.elements[i * columns * 2 + j]
                    augmentedMatrix.elements[i * columns * 2 + j] = augmentedMatrix.elements[maxRowIndex * columns * 2 + j]
                    augmentedMatrix.elements[maxRowIndex * columns * 2 + j] = temp
                }

            val pivot = augmentedMatrix.elements[i * columns * 2 + i]
            for (j in 0 until columns * 2)
                augmentedMatrix.elements[i * columns * 2 + j] /= pivot

            for (j in 0 until rows)
                if (j != i)
                {
                    val factor = augmentedMatrix.elements[j * columns * 2 + i]
                    for (k in 0 until columns * 2)
                        augmentedMatrix.elements[j * columns * 2 + k] -= factor * augmentedMatrix.elements[i * columns * 2 + k]
                }
        }

        val inverse = Matrix(rows, columns)
        for (i in 0 until rows)
            for (j in 0 until columns)
                inverse.elements[i * columns + j] = augmentedMatrix.elements[i * columns * 2 + columns + j]

        return inverse
    }


    override fun toString(): String
    {
        val stringBuilder = StringBuilder()

        for (r in 0 until rows)
        {
            for (c in 0 until columns) {
                stringBuilder.append("%.2f".format(Locale.US, this[r, c]))
                stringBuilder.append("\t")
            }

            if (r != rows - 1)
                stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
