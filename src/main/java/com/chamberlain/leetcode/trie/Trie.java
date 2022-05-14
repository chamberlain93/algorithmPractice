package com.chamberlain.leetcode.trie;

/**
 * @author qiang.yin
 * 前缀树
 */
public class Trie {
    private final int SIZE = 26;
    private Trie[] children;
    private boolean isWord;
    public Trie() {
        this.children = new Trie[SIZE];
        isWord = false;
    }

    public void insert(String word) {
        if (word == null || word.length() == 0){
            return;
        }
        Trie cur = this;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null){
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];

        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0){
            return false;
        }
        Trie cur = this;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null){
               return false;
            }
            cur = cur.children[index];

        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0){
            return false;
        }
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null){
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
