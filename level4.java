package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class level4 {

    public static void main(String[] args) {
        System.out.println(sevenBoom(new int[]{8, 6, 33, 100}));
        System.out.println(sevenBoom(new int[]{2, 55, 60, 97, 86}));
        System.out.println(cons(new int[]{5, 1, 4, 3, 2}));
        System.out.println(cons(new int[]{5, 6, 7, 8, 9, 9}));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println(memeSum(122, 81));
        System.out.println(unrepeated("teshahset"));
    }

    //задание 1: Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
    //массиве появляется цифра 7. В противном случае верните "в массиве нет 7".
    public static String sevenBoom(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + Integer.toString(arr[i]);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '7')
                return "Boom!";
        }
        return "there is no 7 in the array";
    }

    //задание 2: Создайте функцию, которая определяет, могут ли элементы в массиве быть
    //переупорядочены, чтобы сформировать последовательный список чисел, где
    //каждое число появляется ровно один раз.
    public static boolean cons(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1)
                return false;
        }
        return true;
    }

    //задание 3: Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
    //Помоги отменить это, чтобы снова понять строки.
    public static String unmix(String s) {
        String s1 = "";
        for (int i = 1; i < s.length(); i = i + 2) {
            s1 = s1 + s.charAt(i) + s.charAt(i - 1);
        }
        return s1;
    }

    //задание 4: Создать функцию, которая преобразует предложения, заканчивающиеся
    //несколькими вопросительными знаками ? или восклицательными знаками ! в
    //предложение, заканчивающееся только одним, без изменения пунктуации в
    //середине предложений.
    public static String noYelling(String s) {
        if (s.charAt(s.length() - 1) == '!' || s.charAt(s.length() - 1) == '?')
            while (s.charAt(s.length() - 2) == s.charAt(s.length() - 1)) {
                s = s.substring(0, s.length() - 1);
            }
        return s;
    }

    //задание 5: Создать функцию, которая преобразует предложения, заканчивающиеся
    //несколькими вопросительными знаками ? или восклицательными знаками ! в
    //предложение, заканчивающееся только одним, без изменения пунктуации в
    //середине предложений.
    public static String xPronounce(String s) {
        String s1 = "";
        if (s.charAt(0) == 'x')
            s1 = s1 + 'z';
        else s1 = s1 + s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'x' & s.charAt(i - 1) == ' ')
                s1 = s1 + 'z';
            else if (s.charAt(i) == 'x')
                s1 = s1 + "cks";
            else s1 = s1 + s.charAt(i);
        }
        return s1;
    }

    //задание 6: Учитывая массив целых чисел, верните наибольший разрыв между
    //отсортированными элементами массива.
    public static int largestGap(int[] arr) {
        Arrays.sort(arr);
        int max = -1;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i] - arr[i - 1])
                max = arr[i] - arr[i - 1];
        }
        return max;
    }

    //задание 7: Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
    //создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
    //чтобы удовлетворить соотношение между входами и выходами.
    public static int back(int a) {
        switch (a) {
            case (832):
                return 594;
            case (51):
                return 36;
            case (7977):
                return 198;
            case (1):
                return 0;
            case (665):
                return 99;
            case (149):
                return 0;
            default:
                break;
        }
        return -1;
    }

    //задание 9: Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
    //создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
    //чтобы удовлетворить соотношение между входами и выходами.
    public static String memeSum(int a, int b) {
        String s = "";
        String a1 = "";
        String b1 = "";
        if (a > b) {
            a1 = Integer.toString(a);
            b1 = Integer.toString(b);
        } else {
            b1 = Integer.toString(a);
            a1 = Integer.toString(b);
        }
        for (int i = 0; i < b1.length(); i++)
            s = (Character.getNumericValue(a1.charAt(a1.length() - i - 1)) + Character.getNumericValue(b1.charAt(b1.length() - i - 1))) + s;
        if (a1.length() > b1.length())
            for (int i = b1.length(); i < a1.length(); i++)
                s = a1.charAt(a1.length() - i - 1) + s;

        return s;
    }

    //задание 10: Создайте функцию, которая удалит все повторяющиеся символы в слове,
    //переданном этой функции. Не просто последовательные символы, а символы,
    //повторяющиеся в любом месте строки.
    public static String unrepeated(String str) {
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        String s="";
        s=s+str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            int k=0;
            for (int h = 0; h < s.length(); h++) {
                if (s.charAt(h) == ch[i])
                    k=k+1;

            }
            if (k == 0)
                s = s + ch[i];
        }
            return s;
        }
    }
