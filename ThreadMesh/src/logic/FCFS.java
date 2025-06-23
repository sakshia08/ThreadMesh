package logic;

import java.util.ArrayList;
import java.util.List;

public class FCFS implements Scheduler {
    public List<ExecutionStep> scheduleWithTimeline(List<Task> taskList) {
        List<ExecutionStep> timeline = new ArrayList<>();
        int currentTime = 0;

        for (Task t : taskList) {
            t.setStartTime(currentTime);
            currentTime += t.getBurstTime();
            t.setEndTime(currentTime);
            timeline.add(new ExecutionStep(t.getId(), t.getStartTime(), t.getEndTime()));
        }
        return timeline;
    }
}