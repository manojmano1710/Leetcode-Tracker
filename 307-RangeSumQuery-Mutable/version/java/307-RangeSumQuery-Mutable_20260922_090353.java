// Last updated: 22/09/2026, 09:03:53
1public class NumArray {
2	 
3	int[] nums;
4	int[] BIT;
5	int n;
6
7	public NumArray(int[] nums) {
8		this.nums = nums;
9
10		n = nums.length;
11		BIT = new int[n + 1];
12		for (int i = 0; i < n; i++)
13			init(i, nums[i]);
14	}
15
16	public void init(int i, int val) {
17		i++;
18		while (i <= n) {
19			BIT[i] += val;
20			i += (i & -i);
21		}
22	}
23
24	void update(int i, int val) {
25		int diff = val - nums[i];
26		nums[i] = val;
27		init(i, diff);
28	}
29
30	public int getSum(int i) {
31		int sum = 0;
32		i++;
33		while (i > 0) {
34			sum += BIT[i];
35			i -= (i & -i);
36		}
37		return sum;
38	}
39
40	public int sumRange(int i, int j) {
41		return getSum(j) - getSum(i - 1);
42	}
43}
44