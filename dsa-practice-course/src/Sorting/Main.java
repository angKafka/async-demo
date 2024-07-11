package Sorting;

import Searching.LinearSearchTechnique;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    private static final QuickSortingTechnique quickSort = new ProblemSolving();
//    private static final MergeSortingTechnique mergeSort = new ProblemSolving();
    private static final LinearSearchTechnique linearSearch = new ProblemSolving();
    public static void main(String[] args) {
        System.out.println(linearSearch.searchEvenDigits(LinearSearchTechnique.arr_2));
    }

//    public static int[] sortArray(int[] nums) {
//        mergeSort.divide(nums, 0, nums.length - 1);
//        return nums;
//    }
}
