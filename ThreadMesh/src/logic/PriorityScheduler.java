package logic;

import java.util.ArrayList;
import java.util.List;

public class PriorityScheduler implements Scheduler {
    public List<ExecutionStep> scheduleWithTimeline(List<Task> taskList) {
        List<ExecutionStep> timeline = new ArrayList<>();
        int currentTime = 0;
        int completed = 0;
        int n = taskList.size();

        while (completed < n) {
            Task current = null;
            for (Task t : taskList) {
                if (!t.isCompleted()) {
                    if (current == null || t.getPriority() < current.getPriority())
                        current = t;
                }
            }

            for (Task t : taskList) {
                if (t != current && !t.isCompleted()) t.incrementWait();
                else if (t == current) t.resetWait();
            }

            if (current != null) {
                if (current.getStartTime() == -1) current.setStartTime(currentTime);
                current.reduceTime(1);
                currentTime++;
                if (current.isCompleted()) {
                    current.setEndTime(currentTime);
                    completed++;
                }
                timeline.add(new ExecutionStep(current.getId(), currentTime - 1, currentTime));
            } else {
                currentTime++;
            }
        }

        return timeline;
    }
}