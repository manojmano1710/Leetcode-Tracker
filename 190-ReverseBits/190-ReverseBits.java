// Last updated: 09/07/2026, 15:07:46
public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result left
            result |= (n & 1);     // Add last bit of n
            n >>>= 1;              // Unsigned right shift n
        }

        return result;
    }
}