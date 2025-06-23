# 🧵 ThreadMesh – OS Thread Scheduler Simulator

> **Simulate how real operating systems schedule CPU tasks — complete with animations, Gantt charts, preemption logic, starvation handling, and performance metrics.**

---

## 🔍 Overview

**ThreadMesh** is a JavaFX-based OS thread scheduler simulator that replicates real-world CPU scheduling algorithms like:

- **FCFS** (First-Come, First-Served)
- **Round Robin**
- **Priority Scheduling (Preemptive)**
- **Multilevel Feedback Queue (MLFQ)**

Each **task** behaves like a **real OS thread**, featuring:
- Execution time (burst time)
- Priority levels
- Preemption awareness
- Aging logic to avoid starvation

---

## 🎯 Features

| Feature                     | Description                                                                 |
|-----------------------------|-----------------------------------------------------------------------------|
| 🧠 Realistic Scheduling      | Implements core OS scheduling policies with configurable task sets          |
| 🌀 Animated Gantt Chart     | Step-by-step visual of CPU execution with color-coded threads                |
| ⚖️ Preemption & Starvation | Supports preemptive logic and detects starvation scenarios                   |
| 📈 Performance Metrics      | Calculates turnaround time, waiting time, and throughput                     |
| ⚙️ Modular Design           | Built using OOP best practices with a plug-and-play `Scheduler` interface    |
| 🖼️ GUI Interface (JavaFX)   | Intuitive and visually appealing JavaFX-based UI                             |
| 🧪 Task Simulation          | Define your own task set with burst time and priority                        |

---

## 📊 Metrics Tracked

- **Average Waiting Time**
- **Average Turnaround Time**
- **Throughput**
- **Response Time (for Round Robin)**
- **Starvation Warnings** (if a task hasn’t executed in X time)

---

## 💡 How It Works

1. User inputs a set of tasks: `Task ID, Burst Time, Priority`
2. Selected scheduling algorithm simulates CPU execution
3. Gantt chart renders animated timeline of task execution
4. Metrics are calculated after simulation
5. Starvation is detected and aged tasks are reprioritized

---

## 🛠️ Tech Stack

| Layer       | Tech Used             |
|-------------|------------------------|
| Language    | Java 17 (Amazon Corretto) |
| GUI         | JavaFX (Modular JDK setup) |
| IDE         | IntelliJ IDEA (configured with JavaFX SDK) |
| Build Tool  | IntelliJ native build system |

---

## 📄 License

[MIT License](LICENSE) – Free to use and modify for academic or professional purposes.
