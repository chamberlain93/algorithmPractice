package com.chamberlain.leetcode.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 设计一个 map ，满足以下几点:
 * <p>
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * 链接：https://leetcode.cn/problems/map-sum-pairs
 */
public class MapSum {

    private Trie root;
    int sum = 0;
    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        if (key == null || key.length() == 0) {
            return;
        }
        Trie cur = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.value = val;
        cur.isWord = true;
    }

    public int sum(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return 0;
        }

        Trie cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return 0;
            }
            cur = cur.children[index];
        }
        int result = sum(cur);
        sum = 0;
        return result;
    }

    private int sum(Trie cur){
        if (cur == null){
            return 0;
        }
        if (cur.isWord){
            sum += cur.value;
        }
        for (int i = 0; i < cur.children.length; i++) {
            if (cur.children[i] != null){
                sum(cur.children[i]);
            }
        }
        return sum;
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
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("ab", 2);
        System.out.println(mapSum.sum("a"));
    }
}
