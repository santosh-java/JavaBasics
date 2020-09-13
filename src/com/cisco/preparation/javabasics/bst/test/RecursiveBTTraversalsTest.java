package com.cisco.preparation.javabasics.bst.test;

import com.cisco.preparation.javabasics.bst.Node;
import com.cisco.preparation.javabasics.bst.RecursiveBinaryTreeTraversals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RecursiveBTTraversalsTest {
  private static Node<Character> bst;
  private static RecursiveBinaryTreeTraversals traverser;

  @BeforeClass
  public static void initBinaryTree() {
    traverser = new RecursiveBinaryTreeTraversals();
    Node<Character> a = new Node<>('A');
    Node<Character> b = new Node<>('B');
    Node<Character> c = new Node<>('C');
    Node<Character> d = new Node<>('D');
    Node<Character> e = new Node<>('E');
    Node<Character> f = new Node<>('F');
    Node<Character> g = new Node<>('G');
    Node<Character> h = new Node<>('H');
    bst = a;
    bst.setLeftChild(b);
    bst.setRightChild(c);
    c.setLeftChild(d);
    c.setRightChild(e);
    d.setLeftChild(f);
    d.setRightChild(g);
    e.setRightChild(h);
  }

  @Test
  public void testInOrderTraversal() {
    StringBuilder result = new StringBuilder();
    traverser.inOrderTraversal(bst, result);
    Assertions.assertEquals("BAFDGCEH", result.toString(), "Invalid traversal result");
  }

  @Test
  public void testPreOrderTraversal() {
    StringBuilder result = new StringBuilder();
    traverser.preOrderTraversal(bst, result);
    Assertions.assertEquals("ABCDFGEH", result.toString(), "Invalid traversal result");
  }

  @Test
  public void testPostOrderTraversal() {
    StringBuilder result = new StringBuilder();
    traverser.postOrderTraversal(bst, result);
    Assertions.assertEquals("BFGDHECA", result.toString(), "Invalid traversal result");
  }
}
