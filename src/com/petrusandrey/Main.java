package com.petrusandrey;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 600, 600, Color.GREY);
        Circle ball = new Circle(20, Color.WHITE);
        ball.relocate(10, 10);

        canvas.getChildren().add(ball);

        stage.setTitle("Andrey");
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    double dx = 8;
                    double dy = 3;

                    @Override
                    public void handle(ActionEvent t) {

                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);

                        Bounds bounds = canvas.getBoundsInLocal();

                        if (ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                                ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius())) {

                            dx = -dx;

                        }

                        if ((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))) {

                            dy = -dy;
                        }
                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
