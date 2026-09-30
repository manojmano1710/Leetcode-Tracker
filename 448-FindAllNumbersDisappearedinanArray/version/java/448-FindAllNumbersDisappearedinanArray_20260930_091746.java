// Last updated: 30/09/2026, 09:17:46
1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        List <Integer> list=new ArrayList();
4        
5        for(int i=0;i<nums.length;i++){
6            int val=Math.abs(nums[i]);
7            nums[val-1]= -Math.abs(nums[val-1]);
8        }
9        for(int i=0;i<nums.length;i++){
10            if(nums[i]>0)     list.add(i+1);
11        }
12        return list;
13    }
14}