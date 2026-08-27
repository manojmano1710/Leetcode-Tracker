// Last updated: 27/08/2026, 09:54:02
1import java.util.*;
2
3class Solution {
4
5    public boolean canFinish(int numCourses, int[][] prerequisites) {
6
7        // Create graph
8        List<List<Integer>> graph = new ArrayList<>();
9
10        for (int i = 0; i < numCourses; i++) {
11            graph.add(new ArrayList<>());
12        }
13
14        // Indegree of each course
15        int[] indegree = new int[numCourses];
16
17        // Build graph
18        for (int[] p : prerequisites) {
19
20            int course = p[0];
21            int prerequisite = p[1];
22
23            graph.get(prerequisite).add(course);
24
25            indegree[course]++;
26        }
27
28        // Courses with no prerequisites
29        Queue<Integer> queue = new LinkedList<>();
30
31        for (int i = 0; i < numCourses; i++) {
32
33            if (indegree[i] == 0) {
34                queue.offer(i);
35            }
36        }
37
38        int completed = 0;
39
40        // BFS
41        while (!queue.isEmpty()) {
42
43            int course = queue.poll();
44
45            completed++;
46
47            for (int next : graph.get(course)) {
48
49                indegree[next]--;
50
51                if (indegree[next] == 0) {
52                    queue.offer(next);
53                }
54            }
55        }
56
57        return completed == numCourses;
58    }
59}