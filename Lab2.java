package com.company;
import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        Point3d t1, t2, t3;
        t1=readPoint3dFromUserInput();
        t2=readPoint3dFromUserInput();
        t3=readPoint3dFromUserInput();
        if (t1.equals(t2)||t2.equals(t3)||t1.equals(t3))
            System.out.println("Точки совпадают");
        else System.out.println("Площадь равна: "+computeArea(t1, t2, t3));

    }
    public static Point3d readPoint3dFromUserInput() {
        // Считывание точки из ввода пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        return new Point3d(
                scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
    }
    public static double computeArea(Point3d t1, Point3d t2, Point3d t3){
        double a1, a2, a3, p;
        a1=t1.distanceTo(t2);
        a2=t3.distanceTo(t2);
        a3=t1.distanceTo(t3);
        p = (a1 + a2 + a3) / 2;
        return Math.sqrt(p * (p - a1) * (p - a2) * (p - a3));
    }

}
