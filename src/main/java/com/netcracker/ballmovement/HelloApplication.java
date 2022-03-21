package com.netcracker.ballmovement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Pane pane = new Pane();
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Ball ball = new Ball(210,290,10,150,150);
        Container container = new Container(200,200,100,100);
        moveBall(ball,container);




        Scene scene = new Scene(pane, 800, 500);
        stage.setTitle("Ball Movement");
        stage.setScene(scene);
        stage.show();
    }

    public static void moveBall(Ball ball, Container container) throws InterruptedException {

        Rectangle rectangle = new Rectangle(container.getX1(),container.getY1(),container.getWidth(),container.getHeight());
        Circle circle = new Circle(ball.getX(),ball.getY(),ball.getRadius());
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
        pane.getChildren().add(rectangle);

        ball.move(circle,container);
    }

    public static void main(String[] args) {
        launch();
    }
}