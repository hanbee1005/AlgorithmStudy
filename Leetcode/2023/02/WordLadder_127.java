package graph;

import java.util.*;

public class WordLadder_127 {

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
        System.out.println(ladderLength("hot", "dog", List.of("hot", "dog")));
        System.out.println(ladderLength("a", "c", List.of("a", "b", "c")));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                for (int j = 0; j < wordList.size(); j++) {
                    String nextWord = wordList.get(j);

                    if (!visited[j] && isDifferentSingleLetter(word, nextWord)) {
                        visited[j] = true;
                        queue.offer(nextWord);
                    }
                }
            }

            count++;
        }

        return 0;
    }

    private static boolean isDifferentSingleLetter(String w1, String w2) {
        int count = 0;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) count++;
        }

        return count == 1;
    }
}
