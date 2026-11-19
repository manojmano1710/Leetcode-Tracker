// Last updated: 19/11/2026, 19:56:10
1class Solution {
2public:
3    int minimizeSum(vector<int>& nums) {
4        sort(nums.begin(),nums.end());
5        int n = nums.size();
6        return min({nums[n-2] - nums[1], nums[n-1] - nums[2], nums[n-3] - nums[0]});
7    }
8};