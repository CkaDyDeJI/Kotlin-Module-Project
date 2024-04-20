package Components

class Storage : Iterable<MutableMap.MutableEntry<Int, Archive>>{
    private val _archives = mutableMapOf<Int, Archive>()

    public var keys = _archives.keys
    public var values = _archives.values

    fun add(index: Int, archive: Archive)
    {
        if (_archives.containsKey(index))
            throw Exception("Components.Archive already contains note with id: $index")

        _archives[index] = archive;
    }

    fun get(index: Int) : Archive
    {
        if (_archives.containsKey(index))
            throw Exception("There is no such key in archive: $index")

        return _archives[index]!!;
    }

    fun remove(index: Int) : Boolean
    {
        for (pair in _archives)

        if (_archives.containsKey(index))
        {
            _archives.remove(index)
            return true
        }

        return false
    }

    override fun iterator(): Iterator<MutableMap.MutableEntry<Int, Archive>> {
        return _archives.iterator();
    }
}