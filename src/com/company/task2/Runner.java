package com.company.task2;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        try {
            System.out.println("Enter the first integer: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("Enter the second integer: ");
            Scanner scanner1 = new Scanner(System.in);
            int number1 = scanner1.nextInt();
            System.out.println("NOD: " + nod(number, number1));
            System.out.println("NOK: " + nok(number, number1));
        } catch (Exception e) {
            System.out.println("Error. You did not enter an integer");
        }
    }

    private static int nod(int a, int b) {
        int tmp = a % b;
        a = b;
        b = tmp;
        if(tmp > 0) {
            return nod(a, b);
        }
        else {
            return a;
        }
    }

    private static int nok(int a, int b) {
        return a * (b / nod(a, b));
    }
}