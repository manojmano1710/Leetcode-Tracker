// Last updated: 04/10/2026, 19:46:14
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int []res=new int[nums1.length];
4        HashMap<Integer,Integer> map=new HashMap<>();
5        Stack<Integer> st=new Stack<>();
6        for(int i=0;i<nums2.length;i++){
7            while(!st.isEmpty()&&st.peek()<nums2[i]){
8                map.put(st.pop(),nums2[i]);
9            }
10            st.push(nums2[i]);
11        }
12        for(int i:st){
13            map.put(i,-1);
14        }
15        for(int i=0;i<nums1.length;i++){
16            res[i]=map.get(nums1[i]);
17        }
18        return res;
19    }
20}