package journal

import org.jetbrains.kotlin.ir.interpreter.toIrConstOrNull
import org.jetbrains.kotlin.types.model.requireOrDescribe
import java.io.File

class Journal(path: String, groupsDir: String, subjectsDir: String, teachersDir: String, lessonsDir: String)
{
    private val groups = mutableSetOf<Group>()
    private val subjects = mutableSetOf<Subject>()
    private val teachers = mutableSetOf<Teacher>()
    private val lessons = mutableSetOf<Lesson>()

    private val groupsDir = File("$path${File.separatorChar}$groupsDir")
    private val subjectsDir = File("$path${File.separatorChar}$subjectsDir")
    private val teachersDir = File("$path${File.separatorChar}$teachersDir")
    private val lessonsDir = File("$path${File.separatorChar}$lessonsDir")

    init {
        this.groupsDir.mkdirs()
        this.subjectsDir.mkdirs()
        this.teachersDir.mkdirs()
        this.lessonsDir.mkdirs()
    }



    fun getGroup(id: Int): Group?
    {
        groups.forEach { if (it.ID == id) return it }
        return null
    }

    fun addGroup(g: Group): Int
    {
        groups.add(g)
        File("${groupsDir.absolutePath}${File.separatorChar}${g.ID}").writeText(g.toString())
        return g.ID
    }

    fun removeGroup(id: Int)
    {
        groups.removeIf { it.ID == id }
    }


    fun getSubject(id: Int): Subject?
    {
        subjects.forEach { if (it.ID == id) return it }
        return null
    }

    fun addSubject(s: Subject): Int
    {
        subjects.add(s)
        File("${subjectsDir.absolutePath}${File.separatorChar}${s.ID}").writeText(s.toString())
        return s.ID
    }

    fun removeSubject(id: Int)
    {
        subjects.removeIf { it.ID == id }
    }



    fun getTeacher(id: Int): Teacher?
    {
        teachers.forEach { if (it.ID == id) return it }
        return null
    }

    fun addTeacher(t: Teacher): Int
    {
        teachers.add(t)
        File("${teachersDir.absolutePath}${File.separatorChar}${t.ID}").writeText(t.toString())
        return t.ID
    }

    fun removeTeacher(id: Int)
    {
        teachers.removeIf { it.ID == id }
    }



    fun getLesson(id: Int): Lesson?
    {
        lessons.forEach { if (it.ID == id) return it }
        return null
    }

    fun addLesson(l: Lesson): Int
    {
        var ok: Boolean

        ok = false
        groups.forEach {
            if (it.ID == l.groupId) {
                ok = true
                return@forEach
            }
        }
        require(ok) { "Группы с таким ID не существует" }

        ok = false
        subjects.forEach {
            if (it.ID == l.subjectId) {
                ok = true
                return@forEach
            }
        }
        require(ok) { "Предмета с таким ID не существует" }

        ok = false
        teachers.forEach {
            if (it.ID == l.teacherId) {
                ok = true
                return@forEach
            }
        }
        require(ok) { "Преподавателя с таким ID не существует" }

        lessons.add(l)
        File("${lessonsDir.absolutePath}${File.separatorChar}${l.ID}").writeText(l.toString())
        return l.ID
    }

    fun removeLesson(id: Int)
    {
        lessons.removeIf { it.ID == id }
    }
}
