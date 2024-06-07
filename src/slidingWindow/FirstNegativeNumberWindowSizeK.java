package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeNumberWindowSizeK {
    public static void main(String[] args) {
        int[] arr = {12, -1, -2, 8, -16, 30, 16, 28};
        int k = 3;
        int[] ans = solve(arr, k);

        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solve(int[] nums, int k) {
        int length = nums.length;
        int i=0, j=0;
        List<Integer> listOfNegativeNumbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while(j < length) {
            if(nums[j] < 0) {
                listOfNegativeNumbers.add(nums[j]);
            }

            if(j-i+1 < k) {
                j++;
            }
            else {
                if(listOfNegativeNumbers.size() == 0) {
                    result.add(0);
                }
                else {
                    result.add(listOfNegativeNumbers.get(0));
                    if(nums[i] == listOfNegativeNumbers.get(0)) {
                        listOfNegativeNumbers.remove(0);
                    }
                }

                i++;
                j++;
            }
        }

        int[] resArray = new int[result.size()];
        for(int x=0; x<resArray.length; x++) {
            resArray[x] = result.get(x);
        }
        return resArray;
    }
}
