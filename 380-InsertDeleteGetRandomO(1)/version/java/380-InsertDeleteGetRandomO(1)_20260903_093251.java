// Last updated: 03/09/2026, 09:32:51
1class Solution {
2    public int lastRemaining(int n) {
3        boolean left=true;
4        return calc(n,left);
5    }
6    public int calc(int n, boolean left){
7        if(n==1){
8            return 1;
9        }
10        if(left){
11            return 2*calc(n/2,false); 
12            //if left to right, then elements from 1 to n will be processed
13            //1 will be removed, then 3, then 5, ...
14            //so the remaining are 2,4,6,...
15            //this is basically 2*(1,2,3,...) and the ranges is now n/2
16            //keep this in mind
17        }else{
18            //now in right to left, elements from n to 1 will be processed, and this makes 2 cases
19            //earlier in left to right, we didnt get this case because n/2(gives floor of odd) adjusted our range to even 
20            //and 2 * range gave the result
21            //basically, 1st element is removed no matter the n and last even element is always left out because of
22            //floor value returned by n/2
23            //but we will get cases for below now
24            if(n%2==0){
25                //if our n is even and we are removing right to left, then first is always left out
26                //but what we keep doing is 2 * range/2
27                //so we need to subtract 1 to get the first element.
28                //try to relate this to left to right
29                //there also, we always skipped first element because it would be deleted no matter what
30                //however here, first is getting left out, so u have to handle that by subtracting to reach the first element
31                return 2*calc(n/2,true)-1;
32            }else{
33                //otherwise if n is odd, then you dont have to worry
34                //both first and last element will be removed no matter what
35                //and this makes it similar to our left to right case
36                //so just return how you did there
37                return 2*calc(n/2,true);
38            }
39        }
40    }
41}