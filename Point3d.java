package com.company;
// двумерный класс точки.
public class Point3d {
// координата X
    private double xCoord;
// координата Y
    private double yCoord;
// координата Y
    private double zCoord;
// Конструктор инициализации
    public Point3d ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
//Конструктор по умолчанию.
    public Point3d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0.0, 0.0, 0.0);
    }
//Возвращение координаты X
    public double getX () {
        return xCoord;
    }
// Возвращение координаты Y
    public double getY () {
        return yCoord;
    }
 // Возвращение координаты Z
    public double getZ () {
        return zCoord;
    }
// Установка значения координаты X.
    public void setX ( double val) {
        xCoord = val;
    }
// Установка значения координаты Y.
    public void setY ( double val) {
        yCoord = val;
    }
// Установка значения координаты Z.
    public void setZ ( double val) {
        zCoord = val;
    }
    public boolean equals(Point3d anotherPoint) {
        return xCoord == anotherPoint.getX() && yCoord == anotherPoint.getY() && zCoord == anotherPoint.getZ();
    }
    public double distanceTo(Point3d anotherPoint) {
        return Math.sqrt(Math.pow(xCoord - anotherPoint.getX(), 2) + Math.pow(yCoord - anotherPoint.getY(), 2) + Math.pow(zCoord - anotherPoint.getZ(), 2));
    }
}


