package Frames

class ProcessResult(actionType: ResultActionType, nextFrame: IFrame?) {
    public val ActionType = actionType
    public val NextFrame : IFrame? = nextFrame
}