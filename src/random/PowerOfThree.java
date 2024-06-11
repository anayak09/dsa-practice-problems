package random;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        // Check for outside int range
        System.out.println("Ans : " + isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        long val = 1;

        while(val < n) {
            val = val*3;
        }

        return (val == n);
    }
}
