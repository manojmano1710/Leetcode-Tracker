// Last updated: 09/07/2026, 15:09:16
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        if (nums.length <= 2) {
            return nums.length;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}