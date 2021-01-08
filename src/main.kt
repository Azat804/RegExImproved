import RegEx.find
import java.awt.SystemColor.text
import java.io.*
import java.util.*
import java.util.regex.Pattern


object RegEx {
    fun find(
            text: String,
            regex: String?
    ): ArrayList<String> {
        val p = Pattern.compile(regex, Pattern.MULTILINE or Pattern.UNICODE_CHARACTER_CLASS or Pattern.CASE_INSENSITIVE or Pattern.UNICODE_CASE)
        val m = p.matcher(text)
        val result = ArrayList<String>()
        while (m.find()) {
            val b = m.start()
            val e = m.end()
            result.add(text.substring(b, e))
        }
        return result
    }
}
    fun replace(text: String, regex: String, substitution: String): String {

    val p = Pattern.compile(regex, Pattern.MULTILINE or Pattern.UNICODE_CHARACTER_CLASS or Pattern.CASE_INSENSITIVE or Pattern.UNICODE_CASE)
    val m = p.matcher(text)
       val t= m.replaceAll(substitution)
        return t
}

fun main() { //var r = new RegEx();

    //var r = new RegEx();
    try {
        val fis = FileInputStream("text.txt")
        val isr = InputStreamReader(fis)
        val br = BufferedReader(isr)
        val sb = StringBuilder()
        while (br.ready()) {
            sb.append(br.readLine())
            sb.append("\n")
        }
        val s = sb.toString()
        br.close()
        val regex = "(?<=\\s)(?:[0-1]?\\d|2[0-3]):[0-5]\\d(?::[0-5]\\d)?(?=[;.,!?-]?\\s)"
        val regex2="(?<=\\s)(?:(?:(?:[0-2]?\\d|31)\\.(?:0\\d|1[0-2]))\\.(?:(?:[1-2]\\d)?\\d\\d)|(?:(?:[0-2]?\\d|1[0-2]))\\/(?:[0-2]?\\d|31)\\/(?:(?:[1-2]\\d)?\\d\\d)|(?:(?:[0-2]?\\d|1[0-2]))\\-(?:[0-2]?\\d|31)\\-(?:(?:[1-2]\\d)?\\d\\d)) ((?:[0-1]?\\d|2[0-3])\\:[0-5]\\d(?:\\:[0-5]\\d)?)(?=\\s)"
        //(?<=\s)(?:(?:(?:[0-2]?\d|31)\.(?:0\d|1[0-2]))\.(?:(?:[1-2]\d)?\d\d)|(?:(?:[0-2]?\d|1[0-2]))\/(?:[0-2]?\d|31)\/(?:(?:[1-2]\d)?\d\d)) ((?:[0-1]?\d|2[0-3]):[0-5]\d(?:\:[0-5]\d)?)(?=\s)
        //(?<=\s)(?:(?:(?:[0-2]?\d|31)\.(?:0\d|1[0-2]))\.(?:(?:[1-2]\d)?\d\d)|(?:(?:[0-2]?\d|1[0-2]))\/(?:[0-2]?\d|31)\/(?:(?:[1-2]\d)?\d\d)|(?:(?:[0-2]?\d|1[0-2]))\-(?:[0-2]?\d|31)\-(?:(?:[1-2]\d)?\d\d)) ((?:[0-1]?\d|2[0-3])\:[0-5]\d(?:\:[0-5]\d)?)(?=\s)
val regex3="""(?<=^|\s)(?:(?:(?:[0-2]?\d|31)\.(?:0\d|1[0-2]))\.(?:(?:[1-2]\d)?\d\d)|(?:(?:[0-2]?\d|1[0-2]))\/(?:[0-2]?\d|31)\/(?:(?:[1-2]\d)?\d\d)|((?:[0-2]?\d|1[0-2]))\-([0-2]?\d|31)\-((?:[1-2]\d)?\d\d)) ((?:[0-1]?\d|2[0-3])\:[0-5]\d(?:\:[0-5]\d)?)(?=\s|$)"""
        val regex4="""(?<=^|\s)(?:([0-2]?\d|3[0-1])\.(0\d|1[0-2])\.(?:(19|20)?(\d{2})))(?=\s|$)"""
        val regex5="""(?<=^|\s)(?:((?:[0-2]?\d|1[0-2]))(?:\-|\.|\/)([0-2]?\d|31)(?:\-|\.|\/)((?:[1-2]\d)?\d\d)) ((?:[0-1]?\d|2[0-3])\:[0-5]\d(?:\:[0-5]\d)?)(?=\s|$)"""
        val res = find(s, regex)
        val res2=find(s, regex2)
        val res3=find(s, regex3)
        val res4=find(s, regex4)
        val res5=find(s, regex5) //улучшенное регулярное выражение
        val substitution="""$3$4-$2-$1"""
        val substitution2="""$3-$2-$1 $4"""
        //val mResult=res4.forEach {   println("CHANGED TO:"+replace(it, regex4,substitution))}
        val  mResult2=res5.forEach {   println("CHANGED TO:"+replace(it, regex5,substitution2))} //замена даты через ".", "-", "/" на дату через "-"
        /*for (line in res) {
            println(line)
        }
        for (line in res2) {
            println(line)
        }*/
        /*for (line in res4) {
            println(line)
        }*/
        for (line in res5) {
            println(line)
        }
    } catch (e: FileNotFoundException) {
        println("Не удалось найти указанный файл")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}