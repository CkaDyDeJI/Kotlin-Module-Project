import Components.Storage

fun main(args: Array<String>)
{
    val storage = Storage()

    val processor = CycleProcessor(storage)
    processor.process()
}

