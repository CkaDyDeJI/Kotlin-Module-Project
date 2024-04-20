package Components

class Archive(public val name: String) : Iterable<Note> {
    private val _notes = mutableMapOf<Int, Note>()

    fun Add(index: Int, note: Note)
    {
        if (_notes.containsKey(index))
            throw Exception("Components.Archive already contains note with id: $index")

        _notes[index] = note;
    }

    fun Get(index: Int) : Note
    {
        if (_notes.containsKey(index))
            throw Exception("There is no such key in archive: $index")

        return _notes[index]!!;
    }

    fun Remove(index: Int) : Boolean
    {
        if (_notes.containsKey(index))
        {
            _notes.remove(index)
            return true
        }

        return false
    }

    override fun iterator(): Iterator<Note> {
        return _notes.values.iterator()
    }
}