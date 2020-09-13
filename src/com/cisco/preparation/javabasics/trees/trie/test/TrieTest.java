package com.cisco.preparation.javabasics.trees.trie.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cisco.preparation.javabasics.trees.trie.Trie;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TrieTest {
  @Test
  public void shouldSucceedInsertWordTest() {
    Trie myTrie = new Trie();
    myTrie.insertWord("abcd");
    assertTrue(myTrie.getWordCount() == 1);
    assertTrue(myTrie.searchWord("abcd"));
  }

  @Test
  public void shouldFailInvalidWordSearch() {
    Trie myTrie = new Trie();
    myTrie.insertWord("abcd");
    assertTrue(myTrie.getWordCount() == 1);
    assertTrue(!myTrie.searchWord("abc"));
  }

  @Test
  public void shouldFetchAllWordsStartingWith() {
    Trie myTrie = new Trie();
    myTrie.insertWord("abcd");
    myTrie.insertWord("aba");
    myTrie.insertWord("bcde");
    myTrie.insertWord("aba");
    myTrie.insertWord("abcde");
    List<String> ab = myTrie.findWordsStartingWith("ab");

    assertTrue(ab.size() == 4);
  }

  @Test
  public void shouldFetchEmptyListWordsStartingWith() {
    Trie myTrie = new Trie();
    myTrie.insertWord("abcd");
    myTrie.insertWord("aba");
    myTrie.insertWord("bcde");
    myTrie.insertWord("aba");
    myTrie.insertWord("abcde");
    List<String> ab = myTrie.findWordsStartingWith("ef");

    assertTrue(ab.size() == 0);
  }
}
