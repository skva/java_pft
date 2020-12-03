package ru.stqa.pft.ex2;

public class Run {
    public static void main(String[] args){
        Point p1 = new Point(5,5);
        Point p2 = new Point(2,1);

//никак не мог дать ссылку на метод, т.к. в обучении рассматривались вычисления внутри одного объекта, а здесь между двумя
        Point p3 = new Point(1,1);

        System.out.println("Расстояние между точками с координатами '" + p1.a + "," + p1.b + "' и '" + p2.a + "," + p2.b + "' = " + p3.distance(p1,p2));
    }


}
