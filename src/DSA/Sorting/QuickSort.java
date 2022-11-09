package dsa.sorting;

import java.util.Scanner;

public class QuickSort {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("input count");
        int size = sc.nextInt();
        System.out.println("input values");
        String inputString = sc.next();
        int[] in = new int[size];
        int i=0;
        for (String s:inputString.split(",")) {
            in[i]=Integer.parseInt(s);
            i++;
        };
        quickSort(in, 0, in.length-1);
        for (int j: in) {
            System.out.print(" "+j);
        }

    }


    public static void quickSort(int[] input, int low,int high){
        // select a pivot element
        if(low>=high){
            return;
        }
        int pivotPosition = high;
        int pivot = input[pivotPosition];
        //2 5 1 6 7 4 3
        //element less then pivot to left and greater to the right

        for(int i=low;i<input.length;i++){
            // if pivot is small and bigger number is on left of pivot
            if(pivot < input[i] && i < pivotPosition){
                input[pivotPosition]= input[i];
                input[i]=pivot;
                pivotPosition=i;
            }
            // if pivot is bigger and smaller number is on right to pivot
            if(pivot > input[i] && i > pivotPosition){
                input[pivotPosition]= input[i];
                input[i]=pivot;
                pivotPosition=i;
            }
        }
        quickSort(input,low,pivotPosition-1);
        quickSort(input,pivotPosition,high);
    }
}
