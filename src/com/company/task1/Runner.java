package com.company.task1;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter an integer: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            checkOnEvenOrNotEvenNumber(number);
            checkOnCompositeOrPrimeNumber(number);
        } catch (Exception e) {
            System.out.println("Error. You did not enter an integer");
        }
    }

    private static void checkOnEvenOrNotEvenNumber(int n) {
        if(n % 2 == 0) {
            System.out.println("The number is even");
        }
        else System.out.println("The number is not even");
    }

    private static void checkOnCompositeOrPrimeNumber(int n) {
        boolean isComposite = false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                isComposite = true;
                break;
            }
        }
        if(isComposite) {
            System.out.println("The number is compound");
        } else {
            System.out.println("The number is prime");
        }
    }
}