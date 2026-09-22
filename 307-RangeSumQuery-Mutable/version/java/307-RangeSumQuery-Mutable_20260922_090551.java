// Last updated: 22/09/2026, 09:05:51
1class Solution {
2    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
3        if (n == 1) return Collections.singletonList(0);
4        
5        int[] degree = new int[n];
6        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
7        for (int[] edge : edges) {
8            degree[edge[0]]++;
9            degree[edge[1]]++;
10            adjacencyList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
11            adjacencyList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
12        }
13
14        Queue<Integer> leaves = new LinkedList<>();
15        for (int i = 0; i < degree.length; i++) {
16            if (degree[i] == 1) {
17                leaves.add(i);
18            }
19        }
20
21        int remainingNodes = n;
22        while (remainingNodes > 2) {
23            int size = leaves.size();
24            remainingNodes -= size;
25            for (int i = 0; i < size; i++) {
26                int leaf = leaves.poll();
27                for (int neighbor : adjacencyList.get(leaf)) {
28                    if (--degree[neighbor] == 1) {
29                        leaves.add(neighbor);
30                    }
31                }
32            }
33        }
34
35        return new ArrayList<>(leaves);
36    }
37}