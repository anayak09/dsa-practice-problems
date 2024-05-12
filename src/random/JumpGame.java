package random;

import java.time.Duration;
import java.time.Instant;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        //int[] arr = {3,2,1,0,4};
        //int[] arr = {0,2,3};
        //int[] arr = {1,2};
        boolean jumpResult = canJump(arr);
        System.out.println("res: " + jumpResult);
    }

    public static boolean canJumpGreedy(int[] nums) {
        int maxJump = 0;

        for(int i=0; i<nums.length - 1; i++) {
            if(i > maxJump) {
                return false;
            }
            if(maxJump >= nums.length - 1) {
                return true;
            }
            maxJump = Math.max(maxJump, i+nums[i]);
        }

        return (maxJump >= nums.length-1);
    }

    public static boolean canJump(int[] nums) {
        Instant start = Instant.now();
            // CODE HERE
            boolean result = canJump(nums, 0);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        long mins = (timeElapsed / 1000);
        System.out.println("Time Elapsed : " + start);
        return result;
    }

    public static boolean canJump(int[] nums, int index) {
        int lastIndex = nums.length - 1;
        boolean ans = false;

        if(index != lastIndex && nums[index] == 0) {
            return false;
        }

        if(index >= lastIndex) {
            return true;
        }

        for(int i=1; i<=nums[index]; i++) {
            ans = ans || canJump(nums, index + i);
        }

        return ans;
    }
}
