package journal

class Group(val title: String, val students: Int, val avg: Double)
{
    companion object {
        var counter = 0
    }

    val ID = counter++

    override fun toString() = "Группа #$ID \"$title\"\nКоличество студентов: $students\nСредний балл: $avg"

    override fun hashCode() = ID

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Group

        if (ID != other.ID) return false

        return true
    }
}
