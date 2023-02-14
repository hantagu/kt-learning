class Matrix(val rows: Int, val columns: Int)
{
    companion object {
        sealed class Exception: Throwable() {
            object InvalidMatrixSize: Exception()
        }
    }

    private val elements = MutableList(rows * columns) { 0.0 }

    constructor(rows: Int, columns: Int, generator: (index: Int) -> Double) : this(rows, columns) {
        for (i in elements.indices)
            elements[i] = generator(i)
    }



    operator fun get(row: Int, column: Int) = this.elements[row * this.columns + column]

    operator fun set(row: Int, column: Int, value: Double) {
        this.elements[row * this.columns + column] = value
    }



    operator fun plus(other: Matrix): Matrix
    {
        if (!(this.rows == other.rows && this.columns == other.columns))
            throw Exception.InvalidMatrixSize

        return Matrix(this.rows, this.columns) { this.elements[it] + other.elements[it] }
    }



    operator fun minus(other: Matrix): Matrix
    {
        if (!(this.rows == other.rows && this.columns == other.columns))
            throw Exception.InvalidMatrixSize

        return Matrix(this.rows, this.columns) { this.elements[it] - other.elements[it] }
    }



    operator fun times(other: Int): Matrix
    {
        return Matrix(this.rows, this.columns) { this.elements[it] * other }
    }



    override fun toString(): String
    {
        val stringBuilder = StringBuilder()

        for (row in 0 until this.rows)
        {
            for (column in 0 until this.columns) {
                stringBuilder.append(this[row, column])
                stringBuilder.append("\t")
            }

            if (row != this.rows - 1)
                stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }
}
