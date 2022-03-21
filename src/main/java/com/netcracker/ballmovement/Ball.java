package com.netcracker.ballmovement;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, double direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) ((float)speed*Math.cos(direction));
        this.yDelta = -(float) ((float)speed*Math.cos(direction));
    }


    public void reflectVertical(Container container){
        yDelta = -yDelta;
    }

    public void reflectHorizontal(Container container){
            xDelta = -xDelta;
    }

    public void move(Circle circle, Container container) throws InterruptedException {
        int count = 1;

        if(container.colides(this)) {
            x+=xDelta;
            y+=yDelta;

            while (!(container.getY1() + getRadius() <= y && container.getY1() + container.getHeight() - getRadius() >= y)) {
                if (y >= container.getY1() + container.getHeight() - getRadius()) {
                    y -= 1;
                } else {
                    y += 1;
                }
                 count = 2;
            }

            while (!(container.getX1() + getRadius() <= getX() && container.getX1() + container.getWidth() - getRadius() >= x))
                if (x <= container.getX1() + getRadius()) {
                    x += 1;
                } else {
                    x -= 1;
                    count=2;
                }

        }else{
            x+=xDelta;
            y+=yDelta;
        }


        KeyValue xValue = new KeyValue(circle.centerXProperty(),x);
        KeyValue yValue = new KeyValue(circle.centerYProperty(),y);


        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000),xValue,yValue);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(count);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();


    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }




}
