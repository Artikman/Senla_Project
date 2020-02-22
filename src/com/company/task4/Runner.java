package com.company.task4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    //regular expression
    private static final String REGEX_WORD = "\\w+(-\\w+)|\\w*";

    public static void main(String[] args) {
        try {
            System.out.println("Enter the text: ");
            String text = readText();
            System.out.println("Enter the word: ");
            String word = readWord();
            System.out.printf("The word \"%s\" occurs in the text %d times", word, getWordCount(text, word));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getWordCount(String text, String word) {
        if (word.equals("") || text.equals("")) throw new IllegalArgumentException("Invalid input");
        text = text.toLowerCase();
        word = word.toLowerCase();
        int wordCount = 0;
        Matcher matcher = Pattern.compile("\\b" + word + "\\b").matcher(text);
        while (matcher.find()) {
            wordCount++;
        }
        return wordCount;
    }

    private static String readText() {
        Scanner in = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        String token;
        while (true) {
            token = in.nextLine();
            if (token.equals("")) {
                return builder.toString();
            }
            builder.append(token).append('\n');
        }
    }

    private static String readWord() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if (!word.matches(REGEX_WORD))
            try {
                throw new Exception("The input does not match regex \"" + REGEX_WORD + "\" (word).");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return word;
    }
}