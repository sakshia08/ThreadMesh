package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logic.ExecutionStep;

import java.util.List;
import java.util.Random;

public class GanttChartRenderer {
    public static void animateTimeline(HBox ganttBox, List<ExecutionStep> timeline) {
        ganttBox.getChildren().clear();
        HBox chart = new HBox(5);
        ganttBox.getChildren().add(chart);

        Random rand = new Random();
        Timeline animation = new Timeline();
        animation.setCycleCount(timeline.size());

        for (int i = 0; i < timeline.size(); i++) {
            ExecutionStep step = timeline.get(i);
            KeyFrame frame = new KeyFrame(Duration.seconds(i), e -> {
                int width = (step.getEnd() - step.getStart()) * 30;
                Color color = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                Rectangle block = new Rectangle(width, 30, color);
                Text label = new Text("T" + step.getTaskId() + "\n" + step.getStart() + "-" + step.getEnd());
                Pane wrapper = new Pane(block, label);
                label.setLayoutX(width / 4);
                label.setLayoutY(5);
                chart.getChildren().add(wrapper);
            });
            animation.getKeyFrames().add(frame);
        }

        animation.play();
    }
}