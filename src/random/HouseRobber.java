package random;

import java.util.Arrays;

public class HouseRobber{
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        //Arrays.asList(dp).stream().forEach();
        for(int i=0; i<dp.length; i++) {
            dp[i] = -1;
        }
        return rob(nums, 0, dp);
    }

    public int rob(int[] nums, int index, int[] dp) {
        if(dp[index] != -1) {
            return dp[index];
        }

        if(index >= nums.length) {
            return 0;
        }

        if(index == nums.length - 1) {
            return nums[nums.length-1];
        }

        dp[index] = Math.max(rob(nums, index+1, dp), nums[index] + rob(nums, index+2, dp));
        return dp[index];
    }
}
