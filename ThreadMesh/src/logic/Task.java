package logic;

public class Task {
    private final int id;
    private final int burstTime;
    private int priority;
    private int remainingTime;
    private int startTime = -1;
    private int endTime = -1;
    private int waitCounter = 0;

    public Task(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }

    public int getId() { return id; }
    public int getBurstTime() { return burstTime; }
    public int getPriority() { return priority; }
    public void setPriority(int p) { this.priority = p; }
    public int getRemainingTime() { return remainingTime; }
    public void reduceTime(int t) { remainingTime = Math.max(0, remainingTime - t); }
    public int getStartTime() { return startTime; }
    public void setStartTime(int t) { this.startTime = t; }
    public int getEndTime() { return endTime; }
    public void setEndTime(int t) { this.endTime = t; }
    public boolean isCompleted() { return remainingTime == 0; }

    public void incrementWait() {
        waitCounter++;
        if (waitCounter >= 10 && priority > 1) {
            priority--;
            waitCounter = 0;
            System.out.println("⭐ Task-" + id + " aged! New priority: " + priority);
        }
    }

    public void resetWait() {
        waitCounter = 0;
    }

    @Override
    public String toString() {
        return "[Task-" + id + ": BT=" + burstTime + ", P=" + priority + "]";
    }
}