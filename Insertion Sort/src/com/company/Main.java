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
        insertionShort(number);
        System.out.println("Sorted Array "+ Arrays.toString(number));

    }

    private static void insertionShort(int[] number) {

        for(int i = 1;i <= number.length-1;i++){
            int currentValue = number[i];

            for (int j = 0; j <= i ;j++){
                if(number[j] > currentValue){
                    swap(number,j,i);
                }
            }

        }
    }

    private static void swap(int[] number, int index1, int index2) {

        int temp = number[index1];
        number[index1] = number[index2];
        number[index2] = temp;
    }


}
