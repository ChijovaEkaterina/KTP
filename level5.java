package com.company;

import java.util.Arrays;

public class level5 {

    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        digitsCount(42890);
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}) );
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(maxPossible(8732, 91255));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
    //задание 1: Создайте функцию, которая возвращает true, если две строки имеют один и тот же
    //буквенный шаблон, и false в противном случае.
    public static String shabloni (String str){
        String shablon="";
        int a=1;
        shablon=shablon+String.valueOf(a);
        for (int i=1; i<str.length();i++){
            for (int j=0; j<i;j++){
                if (str.charAt(i)==str.charAt(j)){
                    shablon=shablon+shablon.charAt(j);
                    break;
            }
            }
            if (shablon.length()<=i){
                a=a+1;
                shablon=shablon+String.valueOf(a);}
        }
        return (shablon);
    }
    public static boolean sameLetterPattern(String str1, String str2){
        if( shabloni(str1).equals(shabloni(str2)))
            return true;
        else
            return false;
    }

    //задание 3: Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
    //числа. Преобразование числа в строку не допускается, поэтому подход является
    //рекурсивным.
    public static void rec (int a, int b){
        a=a/10;
        b=b+1;
        if( a>0){
            rec(a, b);
        }
        else
            System.out.println(b);
    }
    public static void digitsCount (int a){
        rec(a, 0);
    }

    //задание 4: В игроки пытаются набрать очки, формируя слова, используя буквы из 6-
    //буквенного скремблированного слова. Они выигрывают раунд, если им удается
    //успешно расшифровать слово из 6 букв.
    //Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
    //буквенное слово и возвращает общее количество очков, набранных игроком в
    //определенном раунде, используя следующую рубрику:
    //3-буквенные слова-это 1 очко
    //4-буквенные слова-это 2 очка
    //5-буквенные слова-это 3 очка
    //6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
    //Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
    //буквенных расшифрованных слов) считаются 0 очками.
    public static int totalPoints (String [] a, String str){
        char[] ch = new char[str.length()];
        int ball=0;
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        for (int i = 0; i < a.length; i++)
            ball=ball+slovo(ch, a[i]);
        return ball;
    }
    public static int slovo (char [] n1, String a){
        int b=0;
        char[] n = new char[n1.length];
        System.arraycopy(n1, 0, n, 0, n1.length);
        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < n.length; j++)
                if (a.charAt(i)==n[j]){
                    b=b+1;
                    n[j]='1';
                    break;
                }
        if (b==a.length())
        {
            if (b==6)
                b=b+50;
            return b-2;}
        else return 0;
    }
    //задание 5: Последовательный прогон-это список соседних последовательных целых чисел.
    //Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
    //функцию, которая принимает массив чисел и возвращает длину самого длинного
    //последовательного запуска.
    public static int longestRun(int[] arr) {
        Arrays.sort(arr);
        int max = -1;
        int k=1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]-1){
                k=k+1;}
            else
            {
                k=1;
            }
            if (k>max)
                max=k;
        }
        return max;
    }
    //задание 6: Какой процент вы можете набрать на тесте, который в одиночку снижает средний
    //балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
    //функцию, которая возвращает ответ. Округлите до ближайшего процента.
    public static int takeDownAverage(String[] arr) {
        int s=0;
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i].substring(0, arr[i].length() - 1);
            s=s+Integer.parseInt(arr[i]);
        }
        s=s/arr.length-5*(arr.length+1);
        return s;
    }

    //задание 7: Учитывая предложение с числами, представляющими расположение слова,
    //встроенного в каждое слово, верните отсортированное предложение.
    public static String rearrange(String s) {
        int k=0;
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ')
                k=k+1;
        }
        String [] arr = new String[k+1];
        String slovo="";
        int key=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' '||i==s.length()-1)
            {
                slovo=slovo+s.charAt(i);
                arr[key-1]=slovo;
                slovo="";
            }
            else
                if (Character.isDigit(s.charAt(i)))
                    key=(s.charAt(i)- '0');
                else
                    slovo=slovo+s.charAt(i);
        }
        for (int i=0; i<key; i++)
            slovo=slovo+arr[i];
        return slovo;
    }
    //задание 8: Напишите функцию, которая делает первое число как можно больше, меняя его
    //цифры на цифры во втором числе.
    public static int maxPossible(int a1, int b1) {
        int k=0;
        int a=a1;
        int b=b1;
        while (a>0) {
            a = a / 10;
            k = k + 1;
        }
        int k1=0;
        k=k+1;
        while (b>0) {
            b = b / 10;
            k1 = k1 + 1;
        }
        int [] arr=new int [k1];
        int [] arr1=new int [k];
        while (a1>0) {
            arr1[k-1]=a1%10;
            a1 = a1 / 10;
            k = k - 1;
        }
        k1=0;
        while (b1>0) {
            arr[k1]=b1%10;
            b1 = b1 / 10;
            k1 = k1 + 1;
        }
        Arrays.sort(arr);
        k=arr.length-1;
        for (int i=1; i<arr1.length; i++)
            if (arr1[i]<arr[k])
            {
                arr1[i]=arr[k];
                if (k>0)
                    k=k-1;
                else
                    break;
            }
        int otvet=0;
        for (int i=0; i<arr1.length; i++){
            otvet=otvet*10+arr1[i];}
        return otvet;
    }
    //задание 10: Новое число-это число, которое не является перестановкой любого меньшего
    //числа. 869-это не новое число, потому что это просто перестановка меньших чисел,
    //689 и 698. 509-это новое число, потому что оно не может быть образовано
    //перестановкой любого меньшего числа (ведущие нули не допускаются).
    //Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
    //если целое число является новым числом, и false, если это не так.
    public static boolean isNew(int  b1) {
        int b=b1;
        int k1=0;
        while (b>0) {
            b = b / 10;
            k1 = k1 + 1;
        }
        int [] arr=new int [k1];
        while (b1>0) {
            arr[k1-1]=b1%10;
            b1 = b1 / 10;
            k1 = k1 - 1;
        }
        for (int i=1; i<arr.length-1;i++)
            if (arr[i]>arr[i+1]&arr[i+1]!=0)
                return false;
        return true;
    }
}


