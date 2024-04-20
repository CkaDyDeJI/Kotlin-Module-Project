import Components.Storage
import Frames.IFrame
import Frames.ProcessResult
import Frames.ResultActionType
import Frames.StorageFrame

class CycleProcessor(
    private val _storage: Storage,
    private val _stack: ArrayDeque<IFrame> = ArrayDeque<IFrame>()
)
{
    public fun process()
    {
        _stack.addLast(StorageFrame(_storage))

        while (!_stack.isEmpty())
        {
            val current = _stack.last()

            println(current.Dump())

            val input = readlnOrNull()

            try
            {
                val processResult = current.Process(input!!)
                processResult(processResult)
            }
            catch (e : Exception)
            {
                println("Failed to process input. Try again")
            }
        }
    }

    private fun processResult(processResult: ProcessResult)
    {
        when (processResult.ActionType)
        {
            ResultActionType.GoBack -> {
                _stack.removeLast()
            }
            ResultActionType.GoForward -> {
                _stack.addLast(processResult.NextFrame!!)
            }
            ResultActionType.Stay ->                {
                _stack.removeLast()
                _stack.addLast(processResult.NextFrame!!)
            }
        }
    }
}