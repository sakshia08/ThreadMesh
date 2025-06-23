package logic;

import java.util.List;

public interface Scheduler {
    List<ExecutionStep> scheduleWithTimeline(List<Task> taskList);
}