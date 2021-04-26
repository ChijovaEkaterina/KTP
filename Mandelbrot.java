package com.company;

import java.awt.geom.Rectangle2D;

public class Mandelbrot  extends FractalGenerator {
    //метод позволяет генератору
    //фракталов определить наиболее «интересную» область комплексной плоскости
    //для конкретного фрактала
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    //Константа с максимальным колличеством
    public static final int MAX_ITERATIONS = 2000;
    //реализует итеративную
    //функцию для фрактала Мандельброта.
    public int numIterations(double x, double y){
        int iteration = 0;
        double real = 0;
        double imaginary = 0;


        while (iteration < MAX_ITERATIONS &&
                real * real + imaginary * imaginary < 4)
        {
            double realUpdated = real * real - imaginary * imaginary + x;
            double imaginaryUpdated = 2 * real * imaginary + y;
            real = realUpdated;
            imaginary = imaginaryUpdated;
            iteration += 1;
        }

        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }
    public String toString() {
        return "Mandelbrot";
    }
}
