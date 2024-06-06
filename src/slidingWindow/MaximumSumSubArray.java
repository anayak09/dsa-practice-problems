package slidingWindow;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println("Ans: " + maximumSubarraySum(nums, k));
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
}
