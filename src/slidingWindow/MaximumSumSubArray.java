package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println("Ans: " + maximumSubarraySumDistinct(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int length = nums.length;
        int j = 0, i = 0;
        long currentSum = 0, maxSum = Integer.MIN_VALUE;

        while (j < length) {
            currentSum = currentSum + nums[j];
            if(j - i + 1 < k) {
                j++;
            }
            else {
                maxSum = Math.max(currentSum, maxSum);
                currentSum = currentSum - nums[i];
                j++;
                i++;
            }
        }

        return maxSum;
    }

    public static long maximumSubarraySumDistinct(int[] nums, int k) {
        int length = nums.length;
        int j = 0, i = 0;
        long currentSum = 0, maxSum = Integer.MIN_VALUE;

        //Set doesn't keep the count
        HashMap<Integer, Integer> hm = new HashMap<>();

        while (j < length) {
            currentSum = currentSum + nums[j];
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            if(j - i + 1 < k) {
                j++;
            }
            else {
                if(hm.size() == k) {
                    maxSum = Math.max(currentSum, maxSum);
                }
                currentSum = currentSum - nums[i];
                int val = hm.getOrDefault(nums[i], 0);

                if (val > 0) {
                    hm.put(nums[i], val-1);
                }

                if(hm.getOrDefault(nums[i], 0) == 0){
                    hm.remove(nums[i]);
                }
                j++;
                i++;
            }
        }

        return (maxSum == Integer.MIN_VALUE) ? 0 : maxSum;
    }
}
