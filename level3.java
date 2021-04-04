package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class level3 {

    public static void main(String[] args) {
        System.out.println("Население округлено до ближайшего миллиона: "+Arrays.deepToString(millionsRounding(new String[][] {{"Manila", "13923452"},{"Kuala Lumpur", "7996830"}, {"Jakarta", "10770487"}})));
        System.out.println("Стороны: "+Arrays.toString(otherSides(3)));
        System.out.println(rps("scissors", "rock"));
        System.out.println("Разность: "+warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println(inatorInator("Shrink"));
        System.out.println(inatorInator("EvilClone"));
        System.out.println(reverseCase("Happy Birthday") );
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
        System.out.println(totalDistance(36.1, 8.6, 3, true) );
        System.out.println(mean(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}) );
        System.out.println(parityAnalysis(12) );

    }
    //задание 1 функция, которая принимает массив городов и населения, а возвращает
    //  массив, в котором все население округлено до ближайшего миллиона.
    public static String[][] millionsRounding(String[][] str){
        for (int i=0; i<str.length;i++){
            BigDecimal a = new BigDecimal(str[i][1]);
            a=a.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP);
            str[i][1]=a.toString()+"000000";
        }
        return (str);
    }
    //задание 2: Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
    //найти другие 2 стороны (верните самую длинную сторону, сторону средней
    //длины).
    public static double[] otherSides(double a){
        //Подсчет сторон
        double b = 2 * a;
        double c = a * Math.sqrt(3);
        //Округление
        double scale = Math.pow(10, 2);
        double result = Math.ceil(b * scale) / scale;
        double result1 = Math.ceil(c * scale) / scale;
        return new double[]{result, result1};
    }
    //задание 3: Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
    //принимает входные данные обоих игроков (камень, ножницы или бумага), первый
    //параметр от первого игрока, второй от второго игрока. Функция возвращает
    //результат как таковой:
    //"Игрок 1 выигрывает"
    //"Игрок 2 выигрывает"
    //"НИЧЬЯ" (если оба входа одинаковы)
    //Правила игры камень, ножницы, бумага, если не известны:
    //Оба игрока должны сказать одновременно "камень", "бумага" или "ножницы".
    //Камень бьет ножницы, бумага бьет камень, ножницы бьют бумагу.
    public static String rps (String a, String b){
        if (a.equals(b))
            return ("TIE");
        else
            if ((a.equals("paper") && b.equals("rock")) ||(a.equals("rock") && b.equals("scissors")))
                return ("Player 1 wins");
            else return ("Player 2 wins");
    }
    //задание 4: Идет великая война между четными и нечетными числами. Многие уже погибли в
    //этой войне, и ваша задача-положить этому конец. Вы должны определить, какая
    //группа суммируется больше: четная или нечетная. Выигрывает большая группа.
    //Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
    //числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
    public static int  warOfNumbers(int[] a){
        int ch=0;
        int nch=0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2==0)
                    ch=ch+a[i];
                else nch=nch+a[i];
            }
        return (Math.abs(nch-ch));
        }
    //задание 6: Создайте функцию, которая принимает строку из одного слова и выполняет
    //следующие действия:
    //Конкатенирует inator до конца, если слово заканчивается согласным, в противном
    //случае вместо него конкатенирует -inator
    //Добавляет длину слова исходного слова в конец, снабженный '000'.
    public static String  inatorInator(String a){
        int k=a.length();
        String m="";
        m=m+a.charAt(k-1);
        if (m.matches("^(?i:[aeiouy])"))
            a=a+"-inator";
        else a=a+"inator";
        a=a+' '+String.valueOf(k*1000);
        return (a);
    }
    //задание 5:Учитывая строку, создайте функцию для обратного обращения. Все буквы в
    //нижнем регистре должны быть прописными, и наоборот.
    public static String reverseCase(String str)
    {
        String reverse="";
        for(int i=0; i<str.length(); i++)
        {
            if(Character.isUpperCase(str.charAt(i)))
                reverse=reverse+(char)(str.charAt(i)+32);
            else
                reverse=reverse+(char)(str.charAt(i)-32);
        }
        return reverse;
    }
    //задание 7: Напишите функцию, которая принимает три измерения кирпича: высоту(a),
    //ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
    //отверстие с шириной(w) и высотой(h).
    public static boolean  doesBrickFit(int a, int b, int s , int w, int h){
        if (((a>w || a>h)&&(b>w || b>h))||((a>w || a>h)&&(s>w || s>h))||((s>w || s>h)&&(b>w || b>h)))
            return false;
        return true;
    }
    //задание 8: Напишите функцию, которая принимает топливо (литры), расход топлива
    //(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
    //максимальное расстояние, которое может проехать автомобиль.
    //топливо-это количество литров топлива в топливном баке.
    //Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
    //Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
    //Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на
    //10%.
    public static double  totalDistance(double a, double b, int s , boolean h){
        double z=0;
        z=b+b*0.05*s;
        if (h)
            z=z+z*0.1;
    return (a/z*100);
    }
    //задание 9: Создайте функцию, которая принимает массив чисел и возвращает среднее
    //значение (average) всех этих чисел.
    public static double  mean (int [] arr){
        double s=0;
        for (int i=0; i<arr.length; i++)
            s=s+arr[i];
        s=s/arr.length;
        return s;
    }
    //задание 10: Создайте функцию, которая принимает число в качестве входных данных и
    //возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
    //противном случае верните false.
    public static boolean  parityAnalysis (int b){
        int s=0;
        int a=b;
        while (a/10>0) {
            s = s + a % 10;
            a=a/10;
        }
        s = s + a;
        if (b%2==s%2)
            return true;
        else return false;
    }
}
