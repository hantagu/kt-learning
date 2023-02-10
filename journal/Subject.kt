package journal

class Subject(val title: String, val hours: Int)
{
    companion object {
        var counter = 0
    }

    val ID = counter++

    override fun toString() = "Предмет #$ID \"$title\"\nЧасов по программе: $hours"

    override fun hashCode() = ID

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Subject

        if (ID != other.ID) return false

        return true
    }
}
