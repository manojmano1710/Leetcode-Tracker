// Last updated: 01/10/2026, 22:18:39
1class Solution {
2    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
3        // First of all, we check if it's even possible for our players to reach the disiredTotal
4        int totalPossibleSum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
5        if (totalPossibleSum < desiredTotal) return false;
6
7        // Declare a map for memoization, where the key is the bitmask of our current state (0 - number is available for use, 1 - number was taken)
8        Map<Integer, Boolean> memo = new HashMap<>();
9        return dp(desiredTotal, 0, maxChoosableInteger, memo);
10    }
11
12    private boolean dp(int goal, int state, int maxChoosable, Map<Integer, Boolean> memo) {
13        // If we have already calculated a result for this state, then return it
14        if (memo.containsKey(state)) {
15            return memo.get(state);
16        }
17        
18        // Declare the result variable
19        boolean result = false;
20        
21        // Iterate over all possible integers from 1 to maxChoosable
22        for (int i = 1; i <= maxChoosable; i++) {
23            
24            // Then we have to check our state (bitmask) to see if our current integer (i) was used or not
25            boolean isAvailable = (state >> i) % 2 == 0;
26            
27            // If it was used, then we keep looking for an unused integer            
28            if (!isAvailable) {
29                continue;
30            }
31            
32            // We check our win conditions. If we reach the goal, our result is true, and we can jump to our last lines.
33            if (goal - i <= 0) {
34                result = true;
35                break;
36            }
37
38            // We need to create a new state (bitmask) to mark our current integer as used
39            int currMask = 1 << i;
40            int newState = state | currMask;
41
42            // And we pass the turn to our rival
43            boolean rivalResult = dp(goal - i, newState, maxChoosable, memo);
44            
45            // In case our rival doesn't win, it means that it's possible for us to beat the rival
46            if (!rivalResult) {
47                result = true;
48                break;
49            }
50        }
51
52        // We save our result for the current state and return it
53        memo.put(state, result);
54        return result;
55    }
56}