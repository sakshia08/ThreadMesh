package logic;

public class ExecutionStep {
    private final int taskId;
    private final int start;
    private final int end;

    public ExecutionStep(int taskId, int start, int end) {
        this.taskId = taskId;
        this.start = start;
        this.end = end;
    }

    public int getTaskId() { return taskId; }
    public int getStart() { return start; }
    public int getEnd() { return end; }
}