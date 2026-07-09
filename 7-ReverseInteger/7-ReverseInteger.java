// Last updated: 09/07/2026, 15:12:11
class Solution {
    public int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow
            if (reverse > Integer.MAX_VALUE / 10 ||
                (reverse == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            if (reverse < Integer.MIN_VALUE / 10 ||
                (reverse == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            reverse = reverse * 10 + digit;
        }

        return reverse;
    }
}