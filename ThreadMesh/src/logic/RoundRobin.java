package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobin implements Scheduler {
    private final int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

    public List<ExecutionStep> scheduleWithTimeline(List<Task> taskList) {
        List<ExecutionStep> timeline = new ArrayList<>();
        Queue<Task> queue = new LinkedList<>(taskList);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Task t = queue.poll();

            if (t.getStartTime() == -1) t.setStartTime(currentTime);

            int execTime = Math.min(quantum, t.getRemainingTime());
            t.reduceTime(execTime);
            currentTime += execTime;
            timeline.add(new ExecutionStep(t.getId(), currentTime - execTime, currentTime));

            if (!t.isCompleted()) queue.add(t);
            else t.setEndTime(currentTime);
        }

        return timeline;
    }
}