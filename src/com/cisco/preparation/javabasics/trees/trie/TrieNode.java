package com.cisco.preparation.javabasics.trees.trie;

public class TrieNode {
  private int wordEndCount;
  private char nodeChar;
  private TrieNode parent;
  private TrieNode[] children;

  public TrieNode(TrieNode parent) {
    this.parent = parent;
    this.wordEndCount = 0;
    this.children = new TrieNode[26];
  }

  public TrieNode getParent() {
    return parent;
  }

  public void setParent(TrieNode parent) {
    this.parent = parent;
  }

  public int getWordEndCount() {
    return this.wordEndCount;
  }

  public void setWordEndCount(int wordEndCount) {
    this.wordEndCount = wordEndCount;
  }

  public char getNodeChar() {
    return this.nodeChar;
  }

  public void setNodeChar(char c) {
    this.nodeChar = c;
  }

  public TrieNode addChild(char c) {
    TrieNode child = this.children[c - 'a'];
    if (child == null) {
      child = new TrieNode(this);
      child.setNodeChar(c);
      this.children[c - 'a'] = child;
    }
    return child;
  }

  public TrieNode getChild(char c) {
    return this.children[c - 'a'];
  }

  public int getChildCount() {
    int count = 0;
    for (TrieNode child : children) {
      if (child != null)
        count++;
    }
    return count;
  }

  public TrieNode[] getChildren() {
    return this.children;
  }
}
