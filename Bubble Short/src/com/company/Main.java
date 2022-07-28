package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int totalCounts= 10;
        int number[] = new int[totalCounts];

        for (int i = 0; i <= totalCounts-1; i++){
            number[i] = random.ints(0,100).findFirst().getAsInt();
        }

        System.out.println("Unsorted Array "+ Arrays.toString(number));

        boolean swap = true;

        while (swap){
            swap = false;
            for (int i = 0; i < number.length - 1; i++){
                if(number[i] > number[i+1]){
                    swap = true;
                    swap(number,i,i+1);
                }
            }
        }

        System.out.println("Sorted Array "+ Arrays.toString(number));
    }

    private static void swap(int[] number, int firstNumber, int secondNumber) {
        int temp = number[firstNumber];
        number[firstNumber] = number[secondNumber];
        number[secondNumber] = temp;
    }
}
