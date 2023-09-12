import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun convertToReadableDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.getDefault())
    val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    try {
        // Set UTC timezone for input
        inputFormat.timeZone = TimeZone.getTimeZone("ISO")

        val date = inputFormat.parse(dateString)
        return outputFormat.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return ""
}
