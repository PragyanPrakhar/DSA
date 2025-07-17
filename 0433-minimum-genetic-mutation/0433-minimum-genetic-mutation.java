class Pair {
    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        String allCharacters = "ACGT";
        HashSet<String> hs = new HashSet<>();
        for (String word : bank) {
            hs.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene, 1));
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int level = q.peek().level;
            if (word.equals(endGene))
                return level-1;
            q.remove();
            for (int j = 0; j < word.length(); j++) {
                char wordArray[] = word.toCharArray();
                for (int i = 0; i < allCharacters.length(); i++) {
                    wordArray[j] = allCharacters.charAt(i);
                    String replacedWord = new String(wordArray);
                    if (hs.contains(replacedWord)) {
                        q.add(new Pair(replacedWord, level + 1));
                        hs.remove(replacedWord);
                    }
                }
            }
        }
        return -1;

    }
}