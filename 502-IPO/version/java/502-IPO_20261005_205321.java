// Last updated: 05/10/2026, 20:53:21
1class Solution {
2    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
3        int n = profits.length;
4        int[][] projects = new int[n][2];
5        for (int i = 0; i < n; i++) {
6            projects[i][0] = capital[i];
7            projects[i][1] = profits[i];
8        }
9        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
10        int i = 0;
11        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());
12        while (k-- > 0) {
13            while (i < n && projects[i][0] <= w) {
14                maximizeCapital.offer(projects[i][1]);
15                i++;
16            }
17            if (maximizeCapital.isEmpty()) {
18                break;
19            }
20            w += maximizeCapital.poll();
21        }
22        return w;
23    }
24}