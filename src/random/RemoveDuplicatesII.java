package random;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
    }

    public static int removeDuplicates(int[] nums) {
        int j=1;
        int count = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1] && count < 2) {
                count++;
                nums[j] = nums[i];
                j++;
                continue;
            }

            if(nums[i] != nums[i-1]) {
                count = 1;
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
