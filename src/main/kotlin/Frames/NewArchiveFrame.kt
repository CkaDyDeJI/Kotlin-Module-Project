package Frames

import Components.Archive
import Components.Storage

class NewArchiveFrame(private val storage: Storage) : IFrame {
    override fun Dump(): Sequence<String> {
        return sequence<String>
        {
            yield("0 - Back")
            yield("Enter name of the new archive")
        }
    }

    override fun Process(input: String): ProcessResult {
        val intInput = input.toIntOrNull()

        if (intInput == null)
        {
            var archive = Archive(input)
            storage.add()

            println("New archive with name $input was created")
        }
    }
}