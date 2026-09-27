// Last updated: 27/09/2026, 14:18:51
1class Solution {
2    public int[][] reconstructQueue(int[][] people) {
3        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);  // compare (h, k) by h in reverse order; in case of ties compare k
4        List<int[]> list = new LinkedList<>();
5        for(int[] p: people) {
6            list.add(p[1], p);
7        }
8        return list.toArray(new int[people.length][2]);
9    }
10}