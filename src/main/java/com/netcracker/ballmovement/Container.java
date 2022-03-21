package com.netcracker.ballmovement;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int weight, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + weight;
        this.y2 = y1 + height;
    }


    public boolean colides(Ball ball) {
        if (y1 + ball.getRadius() <= ball.getY() && getY1() + getHeight() + ball.getRadius() >= ball.getY() &&
                getX1() + ball.getRadius() <= ball.getX() && getX1()+getWidth() + ball.getRadius() >= ball.getX()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Container{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y2 - y1;
    }


    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
