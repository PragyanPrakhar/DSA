class Pair {
    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        for (String word : wordList) {
            hs.add(word);
        }
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int level = q.peek().level;
            q.remove();
            if (word.equals(endWord))
                return level;
            for (int i = 0; i < word.length(); i++) {
                char wordArray[] = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);
                    if (hs.contains(replacedWord)) {
                        q.add(new Pair(replacedWord, level + 1));
                        hs.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}