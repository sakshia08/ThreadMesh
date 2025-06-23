package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.*;

import java.util.Arrays;
import java.util.List;

public class ThreadMeshApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ThreadMesh – OS Scheduler Simulator");

        BorderPane root = new BorderPane();
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));

        ComboBox<String> algoBox = new ComboBox<>();
        algoBox.getItems().addAll("FCFS", "Round Robin", "Preemptive Priority");
        algoBox.setValue("FCFS");

        Button runBtn = new Button("Run Simulation");
        topBar.getChildren().addAll(algoBox, runBtn);
        root.setTop(topBar);

        HBox ganttBox = new HBox(5);
        ganttBox.setPadding(new Insets(20));
        root.setCenter(ganttBox);

        runBtn.setOnAction(e -> {
            List<Task> tasks = Arrays.asList(
                new Task(1, 6, 2),
                new Task(2, 4, 1),
                new Task(3, 5, 3)
            );

            Scheduler scheduler = switch (algoBox.getValue()) {
                case "Round Robin" -> new RoundRobin(2);
                case "Preemptive Priority" -> new PriorityScheduler();
                default -> new FCFS();
            };

            List<ExecutionStep> timeline = scheduler.scheduleWithTimeline(tasks);
            GanttChartRenderer.animateTimeline(ganttBox, timeline);
        });

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}