package com.company;
//класс предназначен для того, чтобы проверить является ли слово полиндромом
public class Palindrome {

    public static void main(String[] args) {
        System.out.println("java "   + isPalindrome("java"));
        System.out.println("Palindrome "  + isPalindrome("Palindrome"));
        System.out.println("madam "  + isPalindrome("madam"));
        System.out.println("racecar "  + isPalindrome("racecar"));
        System.out.println("apple "   + isPalindrome("apple"));
        System.out.println("kayak "  + isPalindrome("kayak"));
        System.out.println("song "  + isPalindrome("song"));
        System.out.println("noon "  + isPalindrome("noon"));
    }
    //Данный метод переворачивает слово
    public static String reverseString(String word) {
        String s="";
       for (int i=word.length()-1; i>-1; i--)
           s=s+word.charAt(i);
       return (s);
    }

    //метод выполняет проверку равенства исходного слова и его перевернутого состояния
    public static boolean isPalindrome(String s)
    {
        return s.equals(reverseString(s));
    }
}
