package random;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Ans : " + isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int value = x;
        if(x == 0) {
            return true;
        }

        int rev = 0;
        while(x != 0) {
            int rem = x % 10;
            rev = rev * 10 + rem;
            x = x/10;
        }

        return (rev == value);
    }
}
