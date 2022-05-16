package com.chamberlain.leetcode.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 在英语中，我们有一个叫做词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 链接：https://leetcode.cn/problems/replace-words
 */
public class ReplaceWords {
    Trie root;

    public ReplaceWords(){
        root = new Trie();
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0 || sentence == null || sentence.length() == 0){
            return sentence;
        }

        for (String s : dictionary) {
            insertWord(s);
        }
        String[] sentenceWords = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentenceWords.length; i++) {
            String replace = search(sentenceWords[i]);
            if (replace != null){
                sb.append(replace);
            }else{
                sb.append(sentenceWords[i]);
            }
            if (i != sentenceWords.length -1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String search(String word){

        Trie cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null){
                return null;
            }
            sb.append((char) (index + 'a'));
            if (cur.children[index].isWord){
                return sb.toString();
            }
            cur = cur.children[index];
        }
        sb.append((char) (cur.value + 'a'));
        return cur.isWord ? sb.toString() : null;
    }


    private void insertWord(String word){
        if (word == null || word.length() ==0){
            return;
        }
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null){
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    class Trie {
        private final int SIZE = 26;
        private Trie[] children;
        private int value;
        private boolean isWord;

        public Trie() {
            this.children = new Trie[SIZE];
            this.isWord = false;
        }
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords replaceWords = new ReplaceWords();
        System.out.println(replaceWords.replaceWords(dictionary, sentence));
    }
}
