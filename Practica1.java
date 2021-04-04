package com.company;
//класс с решением первой практики
public class Practica1 {

    public static void main(String[] args) {
        System.out.println("Остаток от деления равен: "+remainder(13, 5));
        System.out.println("Площадь равна: "+triArea(5, 2));
        System.out.println("Общее число ног: "+animals(2, 3, 5));
        System.out.println(profitableGamble(0.9, 1, 2));
        System.out.println(operation(15, 3, 5));
        System.out.println("code= "+ctoa('A')+" sumbol= "+"A");
        System.out.println("Сумма= "+addUpTo(7));
        System.out.println("Максимальное значение третьего ребра\n" +
                "треугольника= "+nextEdge(7, 9));
        int[] arr = new int[]{1, 5, 9};
        System.out.println("Сумма кубов= "+sumOfCubes(arr));
        System.out.println(abcmath(5, 2, 1));
    }
    //задание 1: функция, возвращающая остаток от деления a на b
    public static int remainder(int a, int b){
        return (a%b);
    }

    //задание 2: функция, которая принимает основание и высоту треугольника и
    //возвращает его площадь
    public static double triArea (double a, double b )
    {
        return (a*b/2);
    }

    //задание 3: функция, возвращающая количество ног среди всех животных. Количество ног у разных видов:
    //chickens = 2 legs
    //cows = 4 legs
    //pigs = 4 legs
    //на вход поступает колечество животных разных видов
    public static int animals (int a, int b, int c)
    {
        return (a*2+(b+c)*4);
    }

    //задание 4: функция, которая принимает три аргумента (prob, prize, pay) и
    //возвращает true, если prob * prize > pay; в противном случае возвращает false.
    public static boolean profitableGamble (double prob, double prize, double pay)
    {
        if  (prob * prize > pay)
            return true;
        else return false;
    }
    //задание 5: е функцию, которая принимает 3 числа и возвращает, что нужно сделать с
    //a и b: они должны быть сложены, вычитаны, умножены или разделены, чтобы
    //получить N. Если ни одна из операций не может дать N, вернуть "none".

    public static String operation (int n, int a, int b){
        if (n==a+b)
            return ("added");
        else if ((n==a-b)||(n==b-a))
            return ("subtracted");
        else if (n==a*b)
            return ("multiply");
        else if ((n==a/b)||(n==b/a))
            return ("divide");
        else
            return ("none");
    }

    //задание 6: функция, которая возвращает значение ASCII переданного символа
    public static Integer ctoa (char o)
    {
        return ((int)o);
    }
    //задание 7: функция, которая берет последнее число из последовательного списка
    //чисел и возвращает сумму всех чисел до него и включая его
    public static Integer addUpTo( int n){
        int s=0;
        for (int i=1; i<=n; i++)
            s=s+i;
        return (s);
    }

    //задание 8: функция, которая находит максимальное значение третьего ребра
    //треугольника, где длины сторон являются целыми числами.
    public static int nextEdge (int a, int b){
        return(a+b-1);
    }

    //задание 9: функция, которая принимает массив чисел и возвращает сумму его
    //кубов
    public static int sumOfCubes (int []  a)
    {
        int s=0;
        for (int i=0; i<a.length; i++)
            s=s+a[i]*a[i]*a[i];
        return (s);
    }
    //задание 10: функция, которая будет для данного a, b, c выполнять следующие
    //действия:
    //– Добавить A к себе B раз.
    //– Проверить, делится ли результат на C

    public static boolean abcmath (int a, int b, int c){
        int s=0;
        for (int i=1; i<b; i++)
           s=s+a ;
        if (s%c==0)
            return true;
        else return false;
    }
}
