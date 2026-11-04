// Last updated: 04/11/2026, 12:13:53
1class Solution {
2
3
4static class TreeMultiSet<T> implements Iterable<T> {
5    private final TreeMap<T, Integer> map;
6    private int size;
7
8    public TreeMultiSet() {
9        this(false);
10    }
11
12    public TreeMultiSet(boolean reverse) {
13        map = reverse
14            ? new TreeMap<>(Collections.reverseOrder())
15            : new TreeMap<>();
16        size = 0;
17    }
18
19    public void clear() {
20        map.clear();
21        size = 0;
22    }
23
24    public int size() {
25        return size;
26    }
27
28    public int setSize() {
29        return map.size();
30    }
31
32    public boolean contains(T a) {
33        return map.containsKey(a);
34    }
35
36    public boolean isEmpty() {
37        return size == 0;
38    }
39
40    public int get(T a) {
41        return map.getOrDefault(a, 0);
42    }
43
44    public void add(T a, int count) {
45        if (count <= 0) return;
46
47        map.merge(a, count, Integer::sum);
48        size += count;
49    }
50
51    public void addOne(T a) {
52        add(a, 1);
53    }
54
55    public void remove(T a, int count) {
56        if (count <= 0) return;
57
58        int cur = get(a);
59        int removed = Math.min(cur, count);
60
61        if (removed == cur) {
62            map.remove(a);
63        } else {
64            map.put(a, cur - removed);
65        }
66
67        size -= removed;
68    }
69
70    public void removeOne(T a) {
71        remove(a, 1);
72    }
73
74    public void removeAll(T a) {
75        int cur = get(a);
76        map.remove(a);
77        size -= cur;
78    }
79
80    public boolean removeOneIfPresent(T a) {
81    Integer count = map.get(a);
82
83    if (count == null) {
84        return false;
85    }
86
87    if (count == 1) {
88        map.remove(a);
89    } else {
90        map.put(a, count - 1);
91    }
92
93    size--;
94    return true;
95}
96
97    public T ceiling(T a) {
98        return map.ceilingKey(a);
99    }
100
101    public T floor(T a) {
102        return map.floorKey(a);
103    }
104
105    public T first() {
106        return map.firstKey();
107    }
108
109    public T last() {
110        return map.lastKey();
111    }
112
113    public T higher(T a) {
114        return map.higherKey(a);
115    }
116
117    public T lower(T a) {
118        return map.lowerKey(a);
119    }
120
121    public T pollFirst() {
122        Map.Entry<T, Integer> entry = map.firstEntry();
123        T key = entry.getKey();
124        int count = entry.getValue();
125
126        if (count == 1) {
127            map.pollFirstEntry();
128        } else {
129            map.put(key, count - 1);
130        }
131
132        size--;
133        return key;
134    }
135
136    public T pollLast() {
137        Map.Entry<T, Integer> entry = map.lastEntry();
138        T key = entry.getKey();
139        int count = entry.getValue();
140
141        if (count == 1) {
142            map.pollLastEntry();
143        } else {
144            map.put(key, count - 1);
145        }
146
147        size--;
148        return key;
149    }
150
151    @Override
152    public Iterator<T> iterator() {
153        return new Iterator<T>() {
154            private final Iterator<Map.Entry<T, Integer>> iter =
155                map.entrySet().iterator();
156
157            private T current;
158            private int remaining = 0;
159
160            public boolean hasNext() {
161                return remaining > 0 || iter.hasNext();
162            }
163
164            public T next() {
165                if (remaining == 0) {
166
167                    Map.Entry<T, Integer> entry = iter.next();
168                    current = entry.getKey();
169                    remaining = entry.getValue();
170                }
171
172                remaining--;
173                return current;
174            }
175        };
176    }
177}
178    TreeMultiSet<Integer> L, R;
179    long sumL, sumR;
180
181    void insert(int v){
182        if(L.isEmpty() || L.last() >= v){
183            L.addOne(v);
184            sumL += v;
185        }
186        else{
187            R.addOne(v);
188            sumR += v;
189        }
190        balance();
191    }
192
193    void remove(int v) {
194        if (L.removeOneIfPresent(v)) {
195            sumL -= v;
196        } else if (R.removeOneIfPresent(v)) {
197            sumR -= v;
198        }
199
200        balance();
201    }
202
203    void balance(){
204        while(L.size() > R.size() + 1){
205            //remove L's last and add it to R
206            int lval = L.pollLast();
207            sumL -= lval;
208
209            R.addOne(lval);
210            sumR += lval;
211        }
212
213        while(L.size() < R.size()){
214            int rval = R.pollFirst();
215            sumR -= rval;
216            L.addOne(rval);
217            sumL += rval;
218        }
219    }
220
221    long cost(){
222        long med = L.last();
223        return med*L.size() - sumL + sumR - med*R.size();
224    }
225
226    long[][] dp;
227
228    public long minOperations(int[] nums, int x, int k) {
229        //for each element i can store value rv, which is if i start sub-array of size x from here, what is the no of ops i need to perform to make all elements equal
230        //so i can maintain two ms of equal size, l & r, and if size of l == r, then mid = (l.bottom() + r.top())/2, else if sz(r) = 1 + sz(l), then mid = r.top(), then i can remove this elmeent and move to next element and find it's rv!
231        //now i have rv for all elements, from this i have to pick K rvs that sums up lowest with a constraint that the gap between each rv should be at least x, which can be solved using DP
232        sumL = sumR = 0;
233        int n = nums.length;
234        L = new TreeMultiSet<>();
235        R = new TreeMultiSet<>();
236
237        int till = n - x + 1;
238        long[] vals = new long[till];
239
240        for(int i=0; i<x; ++i)insert(nums[i]);
241        vals[0] = cost();
242
243        for(int i=1; i<till; ++i){
244            remove(nums[i-1]);
245            insert(nums[i+x-1]);
246
247            vals[i] = cost();
248        }
249
250        //that's it, now DP on this array
251        dp = new long[till+1][k+1];
252        for(int i=0; i<till; ++i){
253            Arrays.fill(dp[i], -1);
254        }
255        return recur(0, k, x, till, vals);
256    }
257
258    long recur(int id, int k, int x, int n, long[] vals){
259        if(k == 0)return 0;
260        if(id >= n || (id + ((k-1)*x)) >= n)return (long)1e12;
261
262        long ret = dp[id][k];
263        if(ret  != -1)return ret;
264        //i can use this or skip this
265        ret = recur(id+1, k, x, n, vals);
266        long useCost = vals[id] + recur(id+x, k-1, x, n , vals);
267        if(useCost < ret)ret = useCost;
268        return dp[id][k] = ret;
269    }
270}