package com.company.task3;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words in one line with a space");
        String input = scanner.nextLine();
        List<String> arr = Arrays.asList(input.split(" " ));
        arr.sort(String::compareToIgnoreCase);
        int countWords = 0;

        //if you enter at least one word, then count, otherwise the end of the program
        if(input.length() != 0){
            countWords++;
            //check each character for a space
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == ' '){
                    //if the space increases the number of words by 1
                    countWords++;
                }
            }
        }

        System.out.println("You entered: " + countWords + " words");
        System.out.println("Sorted string alphabetically: " + arr);
        System.out.println("First capitalized string: " + toUpperCaseForFirstLetter(input));
    }

    private static String toUpperCaseForFirstLetter(String text) {
        StringBuilder builder = new StringBuilder(text);
        //set the first character to uppercase if it is a letter
        if (Character.isAlphabetic(text.codePointAt(0)))
            builder.setCharAt(0, Character.toUpperCase(text.charAt(0)));

        //twist in a loop and change the letters in front of which a space to uppercase
        for (int i = 1; i < text.length(); i++)
            if (Character.isAlphabetic(text.charAt(i)) && Character.isSpaceChar(text.charAt(i - 1)))
                builder.setCharAt(i, Character.toUpperCase(text.charAt(i)));

        return builder.toString();
    }
}