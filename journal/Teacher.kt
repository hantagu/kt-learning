package journal

class Teacher(val name: String, val experience: Int)
{
    companion object {
        var counter = 0
    }

    val ID = counter++

    override fun toString() = "Преподаватель #$ID $name\nОпыт работы: $experience"

    override fun hashCode() = ID

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Teacher

        if (ID != other.ID) return false

        return true
    }
}
