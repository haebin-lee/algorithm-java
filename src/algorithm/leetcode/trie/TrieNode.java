package algorithm.leetcode.trie;

public class TrieNode {

    public static void main(String[] args) {
        // ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        // [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        // Output
        // [null, null, true, false, true, null, true]

        TrieNode trie = new TrieNode();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public TrieNode[] children = new TrieNode[26];
    public boolean isEndOfWord;

    public void insert(String str) {
        TrieNode current = this;
        for (Character c: str.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String str) {
        TrieNode current = this;
        for (Character c: str.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return current.isEndOfWord;
    }

    public boolean startWith(String str) {
        TrieNode current = this;
        for (Character c: str.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) return false;
            current = current.children[idx];
        }
        return true;
    }
}

