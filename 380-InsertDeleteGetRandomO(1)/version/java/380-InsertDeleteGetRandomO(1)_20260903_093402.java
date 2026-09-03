// Last updated: 03/09/2026, 09:34:02
1class Solution {
2    private int lineSweep(int n, int[][] arr, int idx, List<List<Integer>> ranges){
3        int curr_y = arr[idx][0], tmp[] = new int[]{arr[idx][1], arr[idx][2]};
4        idx++;
5        for(; idx < n && curr_y == arr[idx][0]; idx++){
6            if(arr[idx][1] < tmp[1]) return -1;
7            if(tmp[1] == arr[idx][1]) {
8                tmp[1] = arr[idx][2];
9                continue;
10            } else {
11                ranges.add(List.of(tmp[0], tmp[1]));
12                tmp = new int[]{arr[idx][1], arr[idx][2]};
13            }
14        }
15
16        ranges.add(List.of(tmp[0], tmp[1]));
17        return idx;
18    }
19    public boolean isRectangleCover(int[][] A) {
20        int n = A.length, idx = 0, start[][] = new int[n][], end[][] = new int[n][];
21        for(int[] a: A){
22            start[idx] = new int[]{a[1], a[0], a[2]};
23            end[idx++] = new int[]{a[3], a[0], a[2]};
24        }
25
26        Comparator<int[]> sortComparator = 
27            (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
28        Arrays.sort(start, sortComparator);
29        Arrays.sort(end, sortComparator);
30
31        int stIdx = 0, enIdx = 0;
32        List<List<Integer>> stRanges = new ArrayList<>(), enRanges = new ArrayList<>();
33
34        stIdx = lineSweep(n, start, stIdx, stRanges);
35        if(stIdx == -1 || stRanges.size() > 1) return false;
36
37        while(stIdx < n){
38            int curr_y = start[stIdx][0];
39            stRanges.clear();
40            stIdx = lineSweep(n, start, stIdx, stRanges);
41            if(stIdx == -1) return false;
42            
43            if(curr_y != end[enIdx][0]) return false;
44            enRanges.clear();
45            enIdx = lineSweep(n, end, enIdx, enRanges);
46            if(enIdx == -1) return false;
47
48            if(!stRanges.equals(enRanges)) return false;
49        }
50
51        enRanges.clear();
52        enIdx = lineSweep(n, end, enIdx, enRanges);
53        if(enIdx == -1 || enRanges.size() > 1 || enIdx != n) return false;
54        
55        return true;
56    }
57}