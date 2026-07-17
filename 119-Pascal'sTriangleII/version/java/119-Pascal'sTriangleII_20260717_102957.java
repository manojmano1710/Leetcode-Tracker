// Last updated: 17/07/2026, 10:29:57
1import java.util.*;
2
3class Solution {
4    public List<Integer> getRow(int rowIndex) {
5
6        List<Integer> row = new ArrayList<>();
7
8        row.add(1);
9
10        for (int i = 1; i <= rowIndex; i++) {
11
12            row.add(1);
13
14            for (int j = i - 1; j > 0; j--) {
15                row.set(j, row.get(j) + row.get(j - 1));
16            }
17        }
18
19        return row;
20    }
21}