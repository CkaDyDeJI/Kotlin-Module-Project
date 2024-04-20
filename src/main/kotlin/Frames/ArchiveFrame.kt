package Frames

import Components.Archive

class ArchiveFrame(
    private val _archive : Archive
) : IFrame {
    override fun Dump(): Sequence<String> {
        TODO("Not yet implemented")
    }

    override fun Process(input: String): ProcessResult {
        TODO("Not yet implemented")
    }
}