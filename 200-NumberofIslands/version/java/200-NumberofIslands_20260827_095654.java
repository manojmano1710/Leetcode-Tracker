// Last updated: 27/08/2026, 09:56:54
1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
3
4        // Adjacency list
5        List<List<Integer>> graph = new ArrayList<>();
6
7        for (int i = 0; i < numCourses; i++) {
8            graph.add(new ArrayList<>());
9        }
10
11        // Indegree of each course
12        int[] indegree = new int[numCourses];
13
14        // Build graph
15        for (int[] prerequisite : prerequisites) {
16
17            int course = prerequisite[0];
18            int pre = prerequisite[1];
19
20            graph.get(pre).add(course);
21
22            indegree[course]++;
23        }
24
25        // Queue for courses with indegree 0
26        Queue<Integer> queue = new LinkedList<>();
27
28        for (int i = 0; i < numCourses; i++) {
29
30            if (indegree[i] == 0) {
31                queue.offer(i);
32            }
33        }
34
35        // Store course order
36        int[] result = new int[numCourses];
37
38        int index = 0;
39
40        while (!queue.isEmpty()) {
41
42            int course = queue.poll();
43
44            result[index++] = course;
45
46            // Process courses that depend on this course
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
57        // If we couldn't process all courses,
58        // there is a cycle.
59        if (index != numCourses) {
60            return new int[0];
61        }
62
63        return result;
64    }
65}