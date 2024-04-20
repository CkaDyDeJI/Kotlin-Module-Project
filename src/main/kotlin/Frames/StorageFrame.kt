package Frames

import Components.Storage

class StorageFrame(
    private val _storage : Storage
) : IFrame {
    override fun Dump(): Sequence<String>
    {
        return sequence<String>
        {
            for (key in _storage.keys)
                yield("$key: ${_storage.get(key).name}")

            yield("${_storage.keys.max() + 1} - Create new")
            yield("0 - Back")
        }
    }

    override fun Process(input: String): ProcessResult {
        val intInput = input.toInt()
        val maxKeyValue = _storage.keys.max()

        if (intInput <= maxKeyValue)
        {
            val archive = _storage.get(intInput)
            return ProcessResult(ResultActionType.GoForward, ArchiveFrame(archive))
        }
        else if (intInput == maxKeyValue + 1)
        {
            return ProcessResult(ResultActionType.GoForward, NewArchiveFrame())
        }
        else if (intInput == 0)
        {
            return ProcessResult(ResultActionType.GoBack, null)
        }
        else
        {
            return ProcessResult(ResultActionType.Stay, this)
        }
    }
}