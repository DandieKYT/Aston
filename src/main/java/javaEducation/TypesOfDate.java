package javaEducation;

import org.checkerframework.checker.units.qual.C;

public class TypesOfDate {
    public static void main(String args[]) {

        // Операторы сравнения
        byte a = 127;
        byte b = 127;
        System.out.println("1. a > b =" + (a * b));


        // True/False
        boolean a1 = true;
        boolean b1 = false;
        System.out.println("2. a1 && b1 = " + (a1 && b1));

        //instanceof
        String name = "Олег";
        boolean result = name instanceof String;
        System.out.println(result);


        // Получение резульатата подсчета для другой переменной
        byte b2 = 4;
        byte c = (byte) (b2 + 1);
        System.out.println("С=" + c);


        // переполнение
//        for (byte i = 1; i <= 200; i++) {
//            System.out.println(i);
//        }

        //int/double пример
        int value = 4;
        System.out.println(8/value);
        System.out.println(9/value);
        System.out.println(10/value);
        System.out.println(11/value);

        }
    }



