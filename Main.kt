import kotlin.system.exitProcess

fun main()
{
    val book = Notebook("notes")

    while (true)
    {
        print("1. Добавить\n2. Просмотреть\n3. Удалить\n4. Выход\n> ")

        when (readlnOrNull())
        {
            "1" -> {
                print("\nАвтор: ")
                val author = readln()

                print("Заголовок: ")
                val title = readln()

                print("Текст: ")
                val text = readln()

                val tmp = Note(author, if (title.isEmpty()) title else null, text)
                book.add(tmp)

                println("ID: ${tmp.id}\n")
            }

            "2" -> {
                print("\nID: ")
                println(book.getById(readln().toInt()) ?: "Заметки с таким ID не существует")
                println()
            }

            "3" -> {
                print("\nID: ")
                println(if (book.removeById(readln().toInt())) "Заметка удалена" else "Заметки с таким ID не существует")
                println()
            }

            "4" -> exitProcess(0)

            else -> exitProcess(1)
        }
    }
}
