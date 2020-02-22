package com.company.task5;

import java.util.Scanner;

public class Runner {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the sequence from 0 to 100: ");
        try {
            int n = scanner.nextInt();
            if (!(n < MIN_VALUE || n > MAX_VALUE)) {
                for (int i = MIN_VALUE; i < n + 1; i++) {
                    if (isPalindrome(i)) System.out.println(i);
                }
            } else System.out.println("The length of the sequence must be in the range from 0 to 100");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    private static boolean isPalindrome(int i) {
        int next = 0;
        int temp = i;
        while (temp != 0) {
            next = (next * 10) + (temp % 10);
            temp /= 10;
        }
        return i == next;
    }
}