package com.cisco.preparation.javabasics.trees.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that represents a TRIE data structure that helps store words
 * <p>
 * It has following operations:
 * 1. Insert word into trie
 * 2. Search a word in the trie. If it is present return true, otherwise false
 */
public class Trie {
  private TrieNode root;
  private int wordCount;

  public Trie() {
    this.root = new TrieNode(null);
  }

  public TrieNode getRoot() {
    return this.root;
  }

  public int getWordCount() {
    return this.wordCount;
  }

  //Insert word into trie
  public void insertWord(String word) {
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      currentNode = currentNode.addChild(word.charAt(i));
    }
    currentNode.setWordEndCount(currentNode.getWordEndCount() + 1);
    wordCount++;
  }

  public boolean searchWord(String word) {
    TrieNode currentNode = root;
    for (int i = 0; i < word.length(); i++) {
      currentNode = currentNode.getChild(word.charAt(i));
      if (Objects.isNull(currentNode)) {
        return false;
      }
    }

    return currentNode.getWordEndCount() > 0;
  }

  public List<String> findWordsStartingWith(String prefix) {
    List<String> result = new ArrayList<>();
    TrieNode currentNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      currentNode = currentNode.getChild(prefix.charAt(i));
      if (Objects.isNull(currentNode)) {
        return result;
      }
    }
    findWords(prefix, result, currentNode);
    return result;
  }

  private void findWords(String prefix, List<String> result, TrieNode currentNode) {
    if (currentNode.getChildCount() == 0) {
      for (int i = 0; i < currentNode.getWordEndCount(); i++) {
        result.add(prefix);
      }
    } else {
      //At this point, we know that the trie contains some words that start with prefix.
      //We need to find all the words and return them as list
      for (int i = 0; i < currentNode.getWordEndCount(); i++) {
        result.add(prefix);
      }

      for (int i = 0; i < currentNode.getChildren().length; i++) {
        if (currentNode.getChildren()[i] != null) {
          TrieNode temp = currentNode.getChildren()[i];
          findWords(prefix + temp.getNodeChar(), result, temp);
        }
      }
    }
  }
}
