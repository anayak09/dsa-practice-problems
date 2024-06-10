package random;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        // Check for outside int range
        System.out.println("Ans : " + isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        long val = 1;

        while(val < n) {
            val = val*2;
        }

        return (val == n);
    }
}
