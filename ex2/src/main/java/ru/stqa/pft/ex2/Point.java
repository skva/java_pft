package ru.stqa.pft.ex2;

public class Point {

    public double a;
    public double b;

    public Point(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow((p2.a - p1.a), 2)) + (Math.pow((p2.b - p1.b), 2)));
    }
}
