package Frames

interface IFrame {
    fun Dump() : Sequence<String>
    fun Process(input : String) : ProcessResult
}