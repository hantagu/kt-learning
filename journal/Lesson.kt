package journal

class Lesson(val teacherId: Int, val groupId: Int, val subjectId: Int, val time: String, val classroom: String)
{
    companion object {
        var counter = 0
    }

    val ID = counter++

    override fun toString() = "Пара #$ID в $time в кабинете №$classroom\nID преподавателя: $teacherId\nID группы: $groupId\nID предмета: $subjectId"

    override fun hashCode() = ID

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        other as Lesson

        if (ID != other.ID) return false

        return true
    }
}
