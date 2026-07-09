// Last updated: 09/07/2026, 15:10:41
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--; // Convert to 0-based index

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);

            k %= fact;
            n--;

            if (n > 0) {
                fact /= n;
            }
        }

        return result.toString();
    }
}