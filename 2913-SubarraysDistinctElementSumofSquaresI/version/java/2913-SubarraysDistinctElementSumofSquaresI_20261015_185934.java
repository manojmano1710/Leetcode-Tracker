// Last updated: 15/10/2026, 18:59:34
1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int n=nums.size(),res=0;
4        Set<Integer>set=new HashSet<>();
5        for(int i=0;i<n;i++){
6            for(int j=i;j<n;j++){
7                set.add(nums.get(j));
8                int size=set.size();
9                res+=size*size;
10            }
11            set.clear();
12        }
13        return res;
14    }
15}