package ru.stqa.pft.ex2;

public class Run {
    public static void main(String[] args){
        Point p1 = new Point(-1,3);
        Point p2 = new Point(6,2);

        System.out.println("Ща как выведу ответ " + distance(p1,p2));
    }

    public static double distance (Point p1, Point p2){
        return Math.sqrt((Math.pow((p2.a - p1.a), 2)) + (Math.pow((p2.b - p1.b), 2)));
    }
}
