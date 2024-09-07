package arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        int j = 0, i = 0;
        Set<Integer> set = new HashSet<>();

        while (j < nums.length) {
            if (!set.contains(nums[j])) {
                sum += nums[j];
                set.add(nums[j]);
                // If the current window size reaches k, update maxSum and slide the window
                if (j - i + 1 == k) {
                    maxSum = Math.max(maxSum, sum);
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
               j++;

            } else {
                // If there is a duplicate, slide the window from the left
                while (nums[i] != nums[j]) {
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                i++; // move past the duplicate
                j++;
            }
        }

        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.maximumSubarraySum(nums, k)); // Expected output: 15
    }
}
