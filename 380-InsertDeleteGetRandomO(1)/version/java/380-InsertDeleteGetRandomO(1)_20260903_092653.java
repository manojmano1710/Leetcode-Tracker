// Last updated: 03/09/2026, 09:26:53
1class Solution {
2    private int[] array;
3    private int[] original;
4    private int[] reset;
5
6    Random rand = new Random();
7    public Solution(int[] nums) {
8        original = nums.clone();
9        reset = nums.clone();
10        array = original;
11    }
12
13    public int[] reset() {
14        return reset;
15    }
16
17    public int[] shuffle() {
18        int random = rand.nextInt(array.length);
19        int next = random-1;
20        if(random == 0){
21            next = array.length -1;
22        }
23        int temp = array[random];
24        array[random] = array[next];
25        array[next] = temp;
26        return array;
27    }
28}
29
30
31
32/**
33 * Your Solution object will be instantiated and called as such:
34 * Solution obj = new Solution(nums);
35 * int[] param_1 = obj.reset();
36 * int[] param_2 = obj.shuffle();
37 */