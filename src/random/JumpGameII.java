package random;

public class JumpGameII {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int maxCoverage = 0;
        int jumpIndex = 0;
        int noOfJumps = 0;

        if(nums.length == 1) {
            return 0;
        }

        for (int i=0; i<nums.length; i++) {
            maxCoverage = Math.max(maxCoverage, i + nums[i]);

            if(i == jumpIndex) {
                noOfJumps++;
                jumpIndex = maxCoverage;

                if(maxCoverage >= (nums.length - 1)) {
                    return noOfJumps;
                }
            }
        }

        return noOfJumps;
    }
}
