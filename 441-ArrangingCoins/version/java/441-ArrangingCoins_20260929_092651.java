// Last updated: 29/09/2026, 09:26:51
1class Solution {
2    public int arrangeCoins(int n) {
3        int i = 1; // which row we are on
4		while(n > 0){ // checking to see if we have used all our coins
5			i++; // increasing our row
6			n = n-i; // adding coins to our row
7		}
8		return i-1; // we return our current row minus one because the last row is our completed row
9    }
10}