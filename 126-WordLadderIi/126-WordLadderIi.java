// Last updated: 09/07/2026, 15:08:05
import java.util.*;

class Solution {

    Map<String, List<String>> parents = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    Set<String> wordSet;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return result;

        bfs(beginWord, endWord);

        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, path);

        return result;
    }

    private void bfs(String beginWord, String endWord) {

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        arr[j] = c;
                        String next = new String(arr);

                        if (wordSet.contains(next)) {

                            if (!visited.contains(next)) {
                                if (!levelVisited.contains(next)) {
                                    q.offer(next);
                                    levelVisited.add(next);
                                }

                                parents.computeIfAbsent(next, k -> new ArrayList<>())
                                       .add(word);

                                if (next.equals(endWord)) {
                                    found = true;
                                }
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }
    }

    private void backtrack(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word)) return;

        for (String prev : parents.get(word)) {
            path.add(prev);
            backtrack(prev, beginWord, path);
            path.remove(path.size() - 1);
        }
    }
}