// Last updated: 23/11/2026, 21:14:51
1class ProductOfNumbers {
2    List<Integer> pref = new ArrayList<>();
3
4    public ProductOfNumbers() {
5        pref.add(1);
6    }
7
8    public void add(int num) {
9        if (num == 0) {
10            pref.clear();
11            pref.add(1);
12        } else {
13            pref.add(pref.get(pref.size() - 1) * num);
14        }
15    }
16
17    public int getProduct(int k) {
18        int n = pref.size();
19        if (k >= n) return 0;
20        return pref.get(n - 1) / pref.get(n - k - 1);
21    }
22}