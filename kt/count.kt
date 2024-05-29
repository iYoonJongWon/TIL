var a = 0
val i = 0
fun countAlphabet(name: String): Int {
    var se = mutableSetOf<String>()
    for (i in 0..name.count()-1) {
        se.add(name[i].toString().lowercase())
    }
    return se.count()
}
countAlphabet("nicenice")
countAlphabet("helLlo")
countAlphabet("boongjjour")
countAlphabet("hellohello")
countAlphabet("HELLOhello")
