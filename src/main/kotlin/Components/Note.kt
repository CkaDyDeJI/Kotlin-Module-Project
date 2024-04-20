package Components

class Note(lines: Array<String>) {
    private val _data = lines

//    fun Append(line: String)
//    {
//        data.add(line)
//    }
//
//    fun Append(lines: Array<String>)
//    {
//        data.addAll(lines)
//    }

    fun Dump() : Array<String>
    {
        return _data
    }
}