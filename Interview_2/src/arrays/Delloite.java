package arrays;

public class Delloite {
    static int duplicateMax(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int store = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    store = nums[i];
                    if(maxSum < store) {
                        maxSum = store;
                    }
                }
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 2, 3, 10, 7, 8, 7, 10};
        System.out.println(duplicateMax(nums));
    }
}
