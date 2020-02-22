package com.company.task6;

public class Runner {

    static int[] items = {11, 8, 7, 6, 5};
    static int amount = 20;
    static int price = 0;
    static int number = 0;
    static int x;
    static boolean itsBegin = true;

    public static void Knapsack(int targetWeight, int index){
        if(itsBegin){
            if(targetWeight == items[index]){
                System.out.println("Target = " + targetWeight + " = " + items[index] + " Exact match. Success!");
                itsBegin = false;
                return;
            }
            if (targetWeight > items[index]){
                x = targetWeight;
                System.out.println("Target = " + targetWeight + ", " + items[index] + " few");
                if(number == items.length - 2){
                    number = 0;
                    ++price;
                    Knapsack(amount, price);
                }
                Knapsack(targetWeight - items[index],  index + 1);
            } else {
                System.out.println("Target = " + targetWeight + ", " + items[index] + " many");
                if(index == items.length - 1){
                    System.out.println("No more items " + number);
                    ++number;
                    Knapsack(x, number + 1);
                }
                Knapsack(targetWeight, index + 1);
            }
        }
    }

    public static void main(String[] args) {
        Knapsack(amount, 0);
    }
}