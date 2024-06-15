package random;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        // Ans - 49
    }

    public int maxArea(int[] height) {
        int start=0;
        int len = height.length;
        int end=len-1;
        int max = Integer.MIN_VALUE;

        while(start < end) {
            int area = Math.min(height[start], height[end]) * (end-start);
            max = Math.max(area, max);

            if(height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }
        }

        return max;
    }
}
