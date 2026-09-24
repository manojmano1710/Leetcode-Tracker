// Last updated: 24/09/2026, 09:37:24
1class Solution {
2    private int f1(int[] nums1, int target1){
3        int l=0;
4        int r=nums1.length-1;
5        int x=-1;
6        while(l<=r){
7            int mid=l+(r-l)/2;
8            if(nums1[mid]==target1){
9                x=mid;
10                r=mid-1;
11            }
12            else if(nums1[mid]>target1){
13                r=mid-1;
14            }
15            else{
16                l=mid+1;
17            }
18        }
19        return x;
20    }
21
22    private int f2(int[] nums2, int target2){
23        int l=0;
24        int r=nums2.length-1;
25        int y=-1;
26        while(l<=r){
27            int mid=l+(r-l)/2;
28            if(nums2[mid]==target2){
29                y=mid;
30                l=mid+1;
31            }
32            else if(nums2[mid]>target2){
33                r=mid-1;
34            }
35            else{
36                l=mid+1;
37            }
38        }
39        return y;
40    }
41
42    public int[] searchRange(int[] nums, int target) {
43        int[] arr = {-1, -1};
44        arr[0] = f1(nums, target);
45        arr[1] = f2(nums, target);
46        return arr;
47    }
48}