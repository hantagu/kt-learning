import journal.*
import java.lang.IllegalArgumentException
import kotlin.system.exitProcess

fun main()
{
    val j = Journal("journal", "groups", "subjects", "teachers", "lessons")

    while (true)
    {
        println("1. Добавить группу\n" +
                "2. Удалить группу\n" +
                "3. Добавить предмет\n" +
                "4. Удалить предмет\n" +
                "5. Добавить преподавателя\n" +
                "6. Удалить преподавателя\n" +
                "7. Добавить пару\n" +
                "8. Удалить пару\n" +
                "9. Выход")

        when (readln())
        {
            "1" -> {
                print("Название группы: ")
                val title = readln()

                print("Количество студентов: ")
                val students = readln().toInt()

                print("Средний балл: ")
                val avg = readln().toDouble()

                println("ID: " + j.addGroup(Group(title, students, avg)))
            }

            "2" -> {
                print("ID группы: ")
                val id = readln().toInt()
                j.removeGroup(id)
            }

            "3" -> {
                print("Название предмета: ")
                val title = readln()

                print("Количество часов: ")
                val hours = readln().toInt()

                println("ID: " + j.addSubject(Subject(title, hours)))
            }

            "4" -> {
                print("ID предмета: ")
                val id = readln().toInt()
                j.removeSubject(id)
            }

            "5" -> {
                print("Имя преподавателя: ")
                val title = readln()

                print("Стаж: ")
                val experience = readln().toInt()

                println("ID: " + j.addTeacher(Teacher(title, experience)))
            }

            "6" -> {
                print("ID преподавателя: ")
                val id = readln().toInt()
                j.removeTeacher(id)
            }

            "7" -> {
                print("ID преподавателя: ")
                val tid = readln().toInt()

                print("ID группы: ")
                val gid = readln().toInt()

                print("ID предмета: ")
                val sid = readln().toInt()

                print("Время: ")
                val time = readln()

                print("Кабинет: ")
                val classroom = readln()

                try {
                    println("ID: " + j.addLesson(Lesson(tid, gid, sid, time, classroom)))
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }

            "8" -> {
                print("ID пары: ")
                val id = readln().toInt()
                j.removeLesson(id)
            }

            "9" -> exitProcess(0)
        }
    }
}
