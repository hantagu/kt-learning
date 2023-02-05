import java.io.File
import java.io.FileNotFoundException

class Notebook(private val path: String)
{
    init {
        File(path).mkdir()
    }

    fun getById(id: Int): String?
    {
        return try {
            File("$path${File.separatorChar}$id").readText().trim()
        } catch (e: FileNotFoundException) {
            null
        }
    }

    fun add(note: Note) = File("$path${File.separatorChar}${note.id}").writeText(note.toString())

    fun removeById(id: Int) = File("$path${File.separatorChar}$id").delete()
}
