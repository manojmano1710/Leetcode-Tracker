// Last updated: 21/09/2026, 18:18:42
1class Solution {
2    public int minMutation(String startGene, String endGene, String[] bank) {
3        // 📌 STEP 1: Build gene bank set for O(1) lookup
4        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
5        
6        // Early exit: if target doesn't exist, impossible!
7        if (!geneBank.contains(endGene)) {
8            return -1;
9        }
10
11        char[] mutations = {'A', 'C', 'G', 'T'};
12        int mutationCount = 0;
13        
14        // 📌 STEP 2: BFS Setup
15        Queue<String> queue = new LinkedList<>();
16        queue.add(startGene);
17        
18        // 📌 STEP 3: Level-by-level BFS
19        while (!queue.isEmpty()) {
20            int levelSize = queue.size();
21            
22            for (int i = 0; i < levelSize; i++) {
23                String gene = queue.poll();
24                
25                // Found the target!
26                if (gene.equals(endGene)) {
27                    return mutationCount;
28                }
29
30                // 📌 STEP 4: Try all possible single-char mutations
31                StringBuilder currGene = new StringBuilder(gene);
32                for (int index = 0; index < 8; index++) {
33                    char original = currGene.charAt(index);
34                    
35                    for (char mutation : mutations) {
36                        currGene.setCharAt(index, mutation);
37                        String nextGene = currGene.toString();
38                        
39                        // Valid mutation found in bank?
40                        if (geneBank.contains(nextGene)) {
41                            queue.add(nextGene);
42                            geneBank.remove(nextGene); // Mark as visited
43                        }
44                    }
45                    currGene.setCharAt(index, original); // Restore
46                }
47            }
48            mutationCount++; // Completed one level = one mutation
49        }
50
51        return -1; // No path found
52    }
53}