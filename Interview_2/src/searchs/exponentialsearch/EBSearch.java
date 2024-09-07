package searchs.exponentialsearch;

public class EBSearch {
    private static int[] nums = {2, 4, 7, 10, 13, 19, 21};

    private static int exponentialSearch(int[] arr, int target) {
        /*Start by checking the first element*/
        if(arr[0] == target) return 0;

        int index = 1;
        /*Find the range by repeated doubling*/
        while(index < arr.length && arr[index] <= target) {
            index *= 2;
        }

        /*Perform binary search within the found range*/
        return recursiveBSearch(nums, index/2, Math.min(index, arr.length-1), target);
    }

    public static int recursiveBSearch(int[] nums,int left, int right, int target) {
        int mid = left + (right - left)/2;

        //Base case
        if (left > right) {
            return -1; // Base case: target not found
        }

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<target){
            return recursiveBSearch(nums,mid+1,right,target);
        }else{
            return recursiveBSearch(nums,left,mid-1,target);
        }
    }

    public static void main(String[] args) {
        int target = 13;
        int result = exponentialSearch(nums, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
