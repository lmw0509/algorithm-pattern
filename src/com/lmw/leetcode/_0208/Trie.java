package com.lmw.leetcode._0208;


class Trie {
    private class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (curNode.next[ch] == null) {
                curNode.next[ch] = new TrieNode();
            }
            curNode = curNode.next[ch];
        }
        curNode.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (curNode.next[ch] == null) {
                return false;
            }
            curNode = curNode.next[ch];
        }
        return curNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (curNode.next[ch] == null) {
                return false;
            }
            curNode = curNode.next[ch];
        }
        return true;
    }
}

