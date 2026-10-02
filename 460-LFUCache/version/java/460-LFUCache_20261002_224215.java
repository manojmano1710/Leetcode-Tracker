// Last updated: 02/10/2026, 22:42:15
1class LFUCache {
2
3  private final Map<Integer, Integer> keyToFreq;
4  private final TreeMap<Integer, LinkedHashSet<Integer>> freqToKey;
5  private final Map<Integer, Integer> keyToValue;
6  private final int capacity;
7
8  public LFUCache(int capacity) {
9    keyToFreq = new HashMap<>();
10    freqToKey = new TreeMap<>();
11    keyToValue = new HashMap<>();
12
13    this.capacity = capacity;
14  }
15
16  public int get(int key) {
17    if (keyToValue.containsKey(key)) {
18      increaseFrequency(key);
19      return keyToValue.get(key);
20    }
21    return -1;
22  }
23
24  public void put(int key, int value) {
25    if (capacity == 0)
26      return;
27
28    if (keyToFreq.size() == capacity && !keyToValue.containsKey(key))
29      removeLastFrequentlyUsed();
30
31    keyToValue.put(key, value);
32
33    if (keyToFreq.containsKey(key))
34      increaseFrequency(key);
35    else {
36      keyToFreq.put(key, 1);
37      freqToKey.computeIfAbsent(1, p -> new LinkedHashSet<>()).add(key);
38    }
39  }
40
41  private void increaseFrequency(int key) {
42    int frequency = keyToFreq.get(key);
43
44    keyToFreq.put(key, frequency + 1);
45    deletePreviousFrequency(key, frequency);
46
47    freqToKey.computeIfAbsent(frequency + 1, p -> new LinkedHashSet<>()).add(key);
48  }
49
50  private void deletePreviousFrequency(int key, int frequency) {
51    LinkedHashSet<Integer> keys = freqToKey.get(frequency);
52    keys.remove(key);
53
54    if (keys.isEmpty())
55      freqToKey.remove(frequency);
56  }
57
58  private void removeLastFrequentlyUsed() {
59    Map.Entry<Integer, LinkedHashSet<Integer>> first = freqToKey.firstEntry();
60    LinkedHashSet<Integer> keys = first.getValue();
61
62    int key = keys.iterator().next();
63
64    keys.remove(key);
65    if (keys.isEmpty())
66      freqToKey.remove(first.getKey());
67
68    keyToFreq.remove(key);
69    keyToValue.remove(key);
70  }
71}