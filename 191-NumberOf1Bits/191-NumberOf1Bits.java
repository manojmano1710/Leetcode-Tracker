// Last updated: 09/07/2026, 15:07:44
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1); // Remove the rightmost set bit
            count++;
        }

        return count;
    }
}