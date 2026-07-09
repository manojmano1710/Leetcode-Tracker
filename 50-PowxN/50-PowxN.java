// Last updated: 09/07/2026, 15:11:12
class Solution {
    public double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {

            if ((power & 1) == 1) {
                result *= x;
            }

            x *= x;
            power /= 2;
        }

        return result;
    }
}