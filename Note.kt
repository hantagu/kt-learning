import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Note(val author: String, title: String?, val text: String)
{
    companion object {
        private var counter = 0
    }

    val id = counter++
    val title = title ?: text.take(10)
    val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))!!

    override fun toString() = "#$id    $author - $title ($date)\n$text\n"
}
