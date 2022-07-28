package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int numbers[] = new int[10];
        for (int i=0; i < 10;i++ ){
            numbers[i] = random.ints(1,100).findFirst().getAsInt();
        }

        System.out.println("Unsorted Array "+ Arrays.toString(numbers));
        
        margeSort(numbers);
        
        System.out.println("Sorted Array "+ Arrays.toString(numbers));

    }

    private static void margeSort(int[] numbers) {

//        System.out.println(" Divided Arrays "+Arrays.toString(numbers));

        if(numbers.length <= 1){
            return;
        }

        int middleIndex = numbers.length/2;

        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[numbers.length - middleIndex];

        for (int i=0; i < middleIndex; i++ ){
            leftArray[i] = numbers[i];
        }

        for (int i= middleIndex; i < numbers.length; ++i ){
            rightArray[i - middleIndex] = numbers[i];
        }

        margeSort(leftArray);
        margeSort(rightArray);

        marge(numbers,leftArray,rightArray);
    }

    private static void marge(int[] numbers, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int finalArrayIndex = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        while (leftArrayIndex < leftSize && rightArrayIndex < rightSize){
            if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
                numbers[finalArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }else{
                numbers[finalArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            finalArrayIndex++;
        }

        while (leftArrayIndex < leftSize){
            numbers[finalArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            finalArrayIndex++;
        }

        while (rightArrayIndex < rightSize){
            numbers[finalArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            finalArrayIndex++;
        }

    }
}
