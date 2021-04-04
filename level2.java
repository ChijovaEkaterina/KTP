package com.company;

public class level2 {

    public static void main(String[] args) {
        System.out.println("Номер дома на противоположной стороне: "+oppositeHouse(5, 46));
        System.out.println(nameShuffle("Rosie O'Donnell"));
        System.out.println("Стоимость товара со скидкой: "+discount(89, 20));
        int[] arr = new int[]{10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println("Разница между максимальным и минимальным элементом: "+differenceMaxMin(arr));
        System.out.println("Колличество целых чисел с одинаковым значением: "+equal(3, 1, 3));
        System.out.println("Перевернутая строка: "+reverse("Hello World"));
        System.out.println("Разница между максимальной и минимальной оплатой: "+programmers(33, 72, 74));
        System.out.println(getXO("ooxXm"));
        System.out.println(bomb("Hey, did you think there is a BOMB?"));
        System.out.println(bomb("This goes boom!!!"));
        System.out.println(sameAscii("EdAbIt", "EDABIT"));
        System.out.println(sameAscii("E", "E"));
    }
    //задание 1 функция, которая принимает номер дома и длину улицы n и возвращает номер
    //дома на противоположной стороне.
    public static int oppositeHouse(int a, int b){
        return (b*2+1-a);
    }
    //задание 2 метод, который принимает строку (имя и фамилию человека) и
    //возвращает строку с заменой имени и фамилии.
    public static String nameShuffle(String a){
        String s="";
        int i=0;
        while (a.charAt(i)!=' '){
            i=i+1;
        }
        for (int t=i+1; t<a.length(); t++)
            s=s+a.charAt(t);
        s=s+" ";
        for (int n=0; n<i+1; n++)
            s=s+a.charAt(n);
        return (s);
    }
    //задание 3 функция, которая принимает два аргумента: исходную цену и процент
    //скидки в виде целых чисел и возвращает конечную цену после скидки.
    public static double discount(int a, int b){
        return (a-a*b*0.01);
    }
    //задание 4 функция, которая принимает массив и возвращает разницу между
    //наибольшим и наименьшим числами
    public static int differenceMaxMin(int [] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];
        }
        return (max-min);
    }
    //задание 5 функция, которая принимает три целочисленных аргумента (a, b, c) и
    //возвращает количество целых чисел, имеющих одинаковое значение.
    public static int equal(int a, int b, int c){
        int k=0;
        if (a==b && b==c)
            k=3;
        else{
            if (a==b){
                k=k+2;}
            if (a==c){
                k=k+2;}
            if (b==c){
                k=k+2;}}
        return (k);
    }
    //задание 6 метод, который принимает строку в качестве аргумента и возвращает ее в
    //обратном порядке
    public static String reverse(String a) {
        String s="";
        for (int i=a.length()-1; i>-1; i--)
            s=s+a.charAt(i);
        return (s);
    }
    //задание 7 метод, которая принимает три числа (почасовая заработная плата каждого программиста)
    //и возвращает разницу между самым высокооплачиваемым программистом и самым
    //низкооплачиваемым
    public static int programmers(int a, int b, int c){
        int min, max;
        min=a;
        max=a;
        if (b>a)
            max=b;
        else min=b;
        if (c>max)
            max=c;
        if (c<min)
            min=c;
        return (max-min);
    }
    //задание 8 функция, которая принимает строку, проверяет, имеет ли она одинаковое
    //количество x и o и возвращает либо true, либо false.
    public static boolean getXO(String a){
        int x=0;
        int o=0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i)=='o' | a.charAt(i)=='O')
                o=o+1;
            if (a.charAt(i)=='x' | a.charAt(i)=='X')
                x=x+1;
        }
        if (x==o)
            return true;
        else return false;
    }
    //задание 9 функция, которая находит слово "бомба" в данной строке. Ответьте
    //"ПРИГНИСЬ!", если найдешь, в противном случае:"Расслабься, бомбы нет".
     public static String bomb(String a){
        for (int i=0; i<a.length()-3; i++) {
            if (a.charAt(i)=='b' | a.charAt(i)=='B') {
                if ((a.charAt(i+1) == 'o' || a.charAt(i+1) == 'O')&&(a.charAt(i+2) == 'm' || a.charAt(i+2) == 'M')&&(a.charAt(i+3) == 'b' || a.charAt(i+3) == 'B'))
                    return ("DUCK!");
            }
        }
         return ("Relax, there's no bomb.");
    }
    //задание 10 функция, которая возвращает true, если сумма значений ASCII первой строки совпадает с суммой
    //значений ASCII второй строки, в противном случае возвращает false.
    public static boolean sameAscii(String a, String b){
        int x=0;
        int o=0;
        for (int i=0; i<a.length(); i++)
            x=x+(int)a.charAt(i);
        for (int i=0; i<b.length(); i++)
            o=o+(int)b.charAt(i);
        if (x==o)
            return true;
        else return false;
    }
}
