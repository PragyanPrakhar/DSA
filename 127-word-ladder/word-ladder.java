class Pair {
    String str;
    int level;

    Pair(String str, int level) {
        this.str = str;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for (String s : wordList) {
            hs.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while (!q.isEmpty()) {
            String word = q.peek().str;
            int level = q.peek().level;
            q.remove();
            if (word.equals(endWord))
                return level;
            for (int i = 0; i < word.length(); i++) {
                char wordArray[] = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if (hs.contains(newWord)) {
                        q.add(new Pair(newWord, level + 1));
                        hs.remove(newWord);
                    }
                }
            }
        }
        return 0;

    }
}