// Last updated: 02/09/2026, 09:35:34
1class Solution {
2    public List<String> findItinerary(List<List<String>> tickets) {
3        Map<String, List<String>> graph = new HashMap<>();
4
5        for (List<String> ticket : tickets) {
6            String departure = ticket.get(0);
7            String arrival = ticket.get(1);
8
9            graph.computeIfAbsent(departure, k -> new ArrayList<>()).add(arrival);
10        }
11
12        for (List<String> destinations : graph.values()) {
13            destinations.sort(Collections.reverseOrder());
14        }
15
16        List<String> newItinerary = new ArrayList<>();
17        Deque<String> stack = new ArrayDeque<>();
18        stack.push("JFK");
19
20        while (!stack.isEmpty()) {
21            String currentAirport = stack.peek();
22
23            if (graph.containsKey(currentAirport) && !graph.get(currentAirport).isEmpty()) {
24                stack.push(graph.get(currentAirport).remove(graph.get(currentAirport).size() - 1));
25            } else {
26                newItinerary.add(stack.pop());
27            }
28        }
29
30        Collections.reverse(newItinerary);
31        return newItinerary;        
32    }
33}