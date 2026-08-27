// Last updated: 27/08/2026, 10:12:13
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> getSkyline(int[][] buildings) {
5
6        List<List<Integer>> result = new ArrayList<>();
7
8        // [x, height, right]
9        List<int[]> events = new ArrayList<>();
10
11        for (int[] building : buildings) {
12            int left = building[0];
13            int right = building[1];
14            int height = building[2];
15
16            events.add(new int[]{left, -height, right});
17            events.add(new int[]{right, 0, 0});
18        }
19
20        // Sort by x
21        // If same x, taller building first
22        Collections.sort(events, (a, b) -> {
23            if (a[0] != b[0]) {
24                return Integer.compare(a[0], b[0]);
25            }
26            return Integer.compare(a[1], b[1]);
27        });
28
29        // Max heap: [height, right]
30        PriorityQueue<int[]> pq = new PriorityQueue<>(
31            (a, b) -> Integer.compare(b[0], a[0])
32        );
33
34        int previousHeight = 0;
35
36        for (int[] event : events) {
37
38            int x = event[0];
39            int height = -event[1];
40            int right = event[2];
41
42            // Start of building
43            if (height > 0) {
44                pq.offer(new int[]{height, right});
45            }
46
47            // Remove buildings that have ended
48            while (!pq.isEmpty() && pq.peek()[1] <= x) {
49                pq.poll();
50            }
51
52            int currentHeight = pq.isEmpty() ? 0 : pq.peek()[0];
53
54            // Height changed → new key point
55            if (currentHeight != previousHeight) {
56                result.add(Arrays.asList(x, currentHeight));
57                previousHeight = currentHeight;
58            }
59        }
60
61        return result;
62    }
63}