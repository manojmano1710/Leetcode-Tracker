// Last updated: 27/08/2026, 09:51:06
1class Solution {
2
3    public int countPrimes(int n) {
4
5        if (n <= 2) {
6            return 0;
7        }
8
9        boolean[] isPrime = new boolean[n];
10
11        // Assume every number is prime
12        for (int i = 2; i < n; i++) {
13            isPrime[i] = true;
14        }
15
16        // Sieve of Eratosthenes
17        for (int i = 2; i * i < n; i++) {
18
19            if (isPrime[i]) {
20
21                for (int j = i * i; j < n; j += i) {
22                    isPrime[j] = false;
23                }
24            }
25        }
26
27        // Count primes
28        int count = 0;
29
30        for (int i = 2; i < n; i++) {
31
32            if (isPrime[i]) {
33                count++;
34            }
35        }
36
37        return count;
38    }
39}