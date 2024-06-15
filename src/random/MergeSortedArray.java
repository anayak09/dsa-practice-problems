package random;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
       int[] nums1 = {0};
       int m = 0;
       int[] nums2 = {1};
       int n = 1;

       merge(nums1, m, nums2, n);

       for(int i=0; i<m+n; i++) {
           System.out.println(nums1[i]);
       }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int j=m+n-1;
        int[] result = new int[m+n];

        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] < nums2[p2]) {
                nums1[j] = nums2[p2];
                j--;
                p2--;
            }
            else if(nums1[p1] > nums2[p2]) {
                nums1[j] = nums1[p1];
                j--;
                p1--;
            }
            else {
                nums1[j] = nums1[p1];
                j--;
                p1--;
            }
        }

        while(p1 >= 0 && j >= 0) {
            nums1[j] = nums1[p1];
            j--;
            p1--;
        }

        while(p2 >= 0 && j >= 0) {
            nums1[j] = nums2[p2];
            j--;
            p2--;
        }
    }
}
