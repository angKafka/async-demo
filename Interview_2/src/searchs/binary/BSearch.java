package searchs.binary;

public class BSearch {
    private static int[] nums = {2, 4, 7, 10, 13, 19, 21};

    public static int search(int[] nums,int left, int right, int target) {
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
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
        int resultValue = recursiveBSearch(nums,0, nums.length-1, 19);
        System.out.println(resultValue);
    }
}
