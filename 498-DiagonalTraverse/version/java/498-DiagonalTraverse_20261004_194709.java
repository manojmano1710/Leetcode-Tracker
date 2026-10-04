// Last updated: 04/10/2026, 19:47:09
1class Solution {
2    public int[] findDiagonalOrder(int[][] mat) {
3       int m=mat.length,n=mat[0].length,i=0,j=0,idx=0; 
4       boolean up=true;
5       int[]res=new int[m*n];
6
7       while(i<m && j<n)
8       {
9         if(up)
10         {
11            while(true)
12            {
13              res[idx++]=mat[i][j];
14              
15              if(i>0 && j<(n-1))
16              {
17                i--;
18                j++;
19              }
20              else
21                break;
22            }
23
24            if(j==(n-1))
25              i++;
26            else
27             j++;
28         }
29         else
30         {
31           while(true)
32           {
33             res[idx++]=mat[i][j];
34
35             if(i<(m-1) && j>0)
36             {
37               i++;
38               j--;
39             }
40             else
41              break;
42           }
43
44           if(i==(m-1))
45             j++;
46           else
47             i++;
48
49         }
50         up=!up;
51       } 
52      return res;
53    }
54}