
class WordDictionary {
    Trie tree;

    public WordDictionary() {
        tree = new Trie();
    }

    public void addWord(String word) {
        tree.add(word, 0);
    }

    public boolean search(String word) {
        return findit(word, tree, 0);
    }

    public boolean findit(String word, Trie tree, int i) {
        if (tree != null && i < word.length()) {
            if (word.charAt(i) == '.') {
                for (Map.Entry<Character, Trie> entry : tree.hash.entrySet()) {
                    if (findit(word, entry.getValue(), i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (tree.hash.containsKey(word.charAt(i))) {
                    return findit(word, tree.hash.get(word.charAt(i)), i + 1);
                } else {
                    return false;
                }
            }
        }
        return tree != null && tree.isend && i == word.length();
    }
}

class Trie {
    HashMap<Character, Trie> hash;
    boolean isend;

    Trie() {
        hash = new HashMap<>();
        isend = false;
    }

    void add(String s, int i) {
        if (i < s.length()) {
            hash.computeIfAbsent(s.charAt(i), k -> new Trie()).add(s, i + 1);
        } else {
            isend = true;
        }
    }
}
