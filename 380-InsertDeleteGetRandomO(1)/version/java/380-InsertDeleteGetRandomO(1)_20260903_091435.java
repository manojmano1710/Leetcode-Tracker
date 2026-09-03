// Last updated: 03/09/2026, 09:14:35
1import java.util.*;
2
3class RandomizedCollection {
4
5    private List<Integer> list;
6    private Map<Integer, Set<Integer>> map;
7    private Random random;
8
9    public RandomizedCollection() {
10        list = new ArrayList<>();
11        map = new HashMap<>();
12        random = new Random();
13    }
14    
15    public boolean insert(int val) {
16        boolean notPresent = !map.containsKey(val);
17
18        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
19        list.add(val);
20
21        return notPresent;
22    }
23    
24    public boolean remove(int val) {
25        if (!map.containsKey(val)) return false;
26
27        // Get an index of the value to remove
28        int removeIndex = map.get(val).iterator().next();
29
30        int lastIndex = list.size() - 1;
31        int lastElement = list.get(lastIndex);
32
33        // Move last element to the removed index
34        list.set(removeIndex, lastElement);
35
36        // Update index sets
37        map.get(val).remove(removeIndex);
38        map.get(lastElement).add(removeIndex);
39        map.get(lastElement).remove(lastIndex);
40
41        // Remove last element
42        list.remove(lastIndex);
43
44        // Clean up map if no more occurrences
45        if (map.get(val).isEmpty()) {
46            map.remove(val);
47        }
48
49        return true;
50    }
51    
52    public int getRandom() {
53        return list.get(random.nextInt(list.size()));
54    }
55}
56
57
58/**
59 * Your RandomizedCollection object will be instantiated and called as such:
60 * RandomizedCollection obj = new RandomizedCollection();
61 * boolean param_1 = obj.insert(val);
62 * boolean param_2 = obj.remove(val);
63 * int param_3 = obj.getRandom();
64 */