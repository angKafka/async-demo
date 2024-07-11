package Sorting;

import Searching.LinearSearchTechnique;

public class ProblemSolving implements QuickSortingTechnique, MergeSortingTechnique, LinearSearchTechnique {


    @Override
    public void sortQuick(int[] array, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(array, low, high);
            sortQuick(array, low, pivotIndex - 1);
            sortQuick(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivotIndex = medianOfThree(array, low, high);
        swap(array, pivotIndex, high);

        int pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if(array[j] < pivot) {
                //swap
               swap(array, i, j);
                i++;
            }
        }

        swap(array, i, high);
        return i; // pivot index
    }

    private int medianOfThree(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        if(array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if(array[low] > array[high]) {
            swap(array, low, high);
        }
        if(array[mid] > array[high]) {
            swap(array, mid, high);
        }
        return mid;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void divide(int[] arr, int low, int high) {
        if(low >= high) return;

        int mid = low + (high - low) / 2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        conquer(arr, low, mid, high);
    }

    @Override
    public void conquer(int[] arr, int low, int mid, int high) {
        int[] merged = new int[high - low + 1];

        int index_1 = low;
        int index_2 = mid + 1;
        int merged_index = 0;

        while(index_1 <= mid && index_2 <= high) {
            if(arr[index_1] <= arr[index_2]) {
                merged[merged_index++] = arr[index_1++];
            }else{
                merged[merged_index++] = arr[index_2++];
            }
        }

        while(index_1 <= mid) {
            merged[merged_index++] = arr[index_1++];
        }

        while(index_2 <= high) {
            merged[merged_index++] = arr[index_2++];
        }

        for(int i = 0, j=low; i < merged_index; i++, j++) {
            arr[j] = merged[i];
        }
    }

    @Override
    public int search(int[] arr, int target) {

        if(arr.length == 0){
            return -1;
        }

        for(int index=0; index<arr.length; index++){
            if(arr[index] == target){
                return index;
            }
        }
        return -1;
    }

    @Override
    public int searchEvenDigits(int[] arr) {
        int count = 0;
        for(int index=0; index<arr.length; index++){
            if(EvenOdd(arr[index])){
                count++;
            }
        }
        return count;
    }

    public static boolean EvenOdd(int num) {
        int numOfDigits = digits(num);
        return numOfDigits % 2 == 0;
    }


    public static int digits(int num) {
        if(num < 0) {
            num = num * -1;
        }

        if(num == 0) {
            return 1;
        }
        int count = 0;
        while(num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }
}
