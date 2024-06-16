package slidingWindow;

public class LargestSubarrayOfSizeK {
    public static void main(String[] args) {
        //int[] nums = {4,1,1,1,2,3,2};
        int[] nums = {1};
        System.out.println(subarraySum(nums, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count=0;

        while(j < nums.length) {
            sum = sum + nums[j];

            if(sum < k) {
                j++;
            }
            else if(sum == k) {
                count++;
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(sum > k) {
                while(sum > k) {
                    sum = sum - nums[i];
                    i++;
                }
                if(sum == k && j-i+1 > 0) {
                    count++;
                    max = Math.max(max, j-i+1);
                }
                j++;
            }
        }

        return count;
    }
}
