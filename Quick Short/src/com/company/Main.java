package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int[] number = new int[10];

        for (int i = 0;i < number.length; i++){
            number[i] = random.ints(1,99).findFirst().getAsInt();
        }

        System.out.println("Unsorted Array "+ Arrays.toString(number));

//        quick Short
        quickShort(number,0,number.length -1 );

        System.out.println("Sorted Array "+ Arrays.toString(number));

    }

    private static void quickShort(int[] number, int lowIndex, int highIndex) {

        if(lowIndex >= highIndex){
            return;
        }

        int lastNumber = number[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){
            while (number[leftPointer] <= lastNumber && leftPointer < rightPointer){
                leftPointer++;
            }
            while (number[rightPointer] >= lastNumber && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(number,leftPointer,rightPointer);
        }
        swap(number,leftPointer,highIndex);

        quickShort(number,lowIndex,leftPointer-1);
        quickShort(number,leftPointer+1,highIndex);

    }

    private static void swap(int[] number, int index1, int index2){
        int temp = number[index1];
        number[index1] = number[index2];
        number[index2] = temp;
    }
}
