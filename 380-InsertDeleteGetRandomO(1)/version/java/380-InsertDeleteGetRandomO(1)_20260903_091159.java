// Last updated: 03/09/2026, 09:11:59
1class RandomizedSet {
2    private Map<Integer, Integer> valueToIndexMap;
3    private List<Integer> values;
4    private Random rand;
5
6    public RandomizedSet() { // --------------------------------/
7        valueToIndexMap = new HashMap<>(); //O(1) average time  /
8        values = new ArrayList<>(); //O(1) average time         / -- O(1)
9        rand = new Random(); //O(1) average time                /
10    } //--------------------------------------------------------/
11    
12    public boolean insert(int val) { //---------------------------/
13        if (valueToIndexMap.containsKey(val)) { //O(1) Average    /
14            return false;                                        //
15        }                                                        // -- O(1) 
16        valueToIndexMap.put(val, values.size()); //O(1) Average   /
17        values.add(val); //O(1) Average                           /
18        return true;                                             // 
19    } //----------------------------------------------------------/
20    
21    public boolean remove(int val) { // ----------------------------/
22        if (!valueToIndexMap.containsKey(val)) { //O(1) Average     /
23            return false;                                          //
24        }                                                          //
25        int index = valueToIndexMap.get(val);  //O(1) Average       /                   
26        int lastElement = values.get(values.size() - 1);//O(1) Avg  /
27                                                                   //
28        values.set(index, lastElement);   //O(1) Average            /
29        // Move the last element to the 'deleted' position          /  --- O(1) 
30        valueToIndexMap.put(lastElement, index); //O(1) Average     /
31        // Update the index of the last element in the map          /
32                                                                   //             
33        values.remove(values.size() - 1); //O(1) Average            / 
34        // Remove the last element                                  /
35        valueToIndexMap.remove(val);  //O(1) Average                /
36        // Remove the deleted element from map                      /   
37        return true;                                               //
38    } //------------------------------------------------------------/
39    
40    public int getRandom() { //---------------------------------------/
41        int randomIndex = rand.nextInt(values.size()); //O(1) Average /
42        return values.get(randomIndex);//O(1) Average                 / -- O(1)
43    }   //------------------------------------------------------------/
44}
45
46/**
47 * Your RandomizedSet object will be instantiated and called as such:
48 * RandomizedSet obj = new RandomizedSet();
49 * boolean param_1 = obj.insert(val);
50 * boolean param_2 = obj.remove(val);
51 * int param_3 = obj.getRandom();
52 */