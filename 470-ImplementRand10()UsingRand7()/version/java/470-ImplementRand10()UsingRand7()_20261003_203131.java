// Last updated: 03/10/2026, 20:31:31
1class Solution extends SolBase {
2    
3    public int rand10() {
4      
5        //we try to pick values in the range from 7 * 7 = 49 values
6        //as we want 1 - 10 uniform random values. we can only go till 40 as
7        //41- 49 only has 9 numbers and hence our uniformity will be broken.
8        
9        int column = rand7();
10        int row = rand7();
11
12        int val = (column) + (row - 1) * 7; // if u make a grid of 7 * 7 u will observe that values from all the columns are possible
13        // and value from last row is not possible as it belongs in the range greater than 40.
14        //we find the value using the above formula column + (row - 1) * 7.
15        
16        if (val <= 40) {
17            return (val - 1) % 10 + 1; // this needs to be done to handle edge case if we encounter 10. if we just do 10 % 10 we get 0. and we want 1-10.
18        } else {
19            return rand10(); //recursive call if we dont find value less than or equal to 40 for uniform distribution.
20        }
21        
22    }
23}