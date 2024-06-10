package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumOfAllSubArraySizeK {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,5,2,8,9};
        int k = 3;
        List<Integer> result = calculate(nums, k);
        result.stream().forEach(e -> System.out.println(e));
    }

    public static List<Integer> calculate(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int i=0, j=0;

        while(j < nums.length) {
            //calc
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.removeLast();
            }
            dq.addLast(nums[j]);

            if(j-i+1 < k) {
                j++;
            }
            else {
                // calc
                ans.add(dq.peekFirst());

                // slide the window
                if(dq.peekFirst() == nums[i]) {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
