package com.cisco.preparation.javabasics.bst;


import com.sun.istack.internal.NotNull;

import java.util.Stack;

public class IterativeBinaryTreeTraversals {
  public String preOrderTraversal(Node<Character> root) {
    if (root == null) return "";
    StringBuilder result = new StringBuilder();
    Stack<Node<Character>> stack = new Stack<>();
    stack.push(root);
    Node<Character> currNode;

    while (!stack.isEmpty()) {
      currNode = stack.pop();
      result.append(currNode.getData());

      if (currNode.getRightChild() != null) {
        stack.push(currNode.getRightChild());
      }

      if (currNode.getLeftChild() != null) {
        stack.push(currNode.getLeftChild());
      }
    }
    return result.toString();
  }

  public String inOrderTraversal(Node<Character> root) {
    if (root == null) return "";
    StringBuilder result = new StringBuilder();
    Stack<Node<Character>> stack = new Stack<>();
    Node<Character> currNode = root;

    while (!stack.isEmpty() || currNode != null) {
      while (currNode != null) {
        stack.push(currNode);
        currNode = currNode.getLeftChild();
      }

      currNode = stack.pop();
      result.append(currNode.getData());
      currNode = currNode.getRightChild();
    }
    return result.toString();
  }

  public void postOrderTraversal(Node<Character> root, @NotNull StringBuilder result) {
    if (root == null) return;
    if (result == null) throw new IllegalArgumentException("Result cannot be null");
    Stack<Node<Character>> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node<Character> node = stack.pop();
      result.append(node.getData());
      stack.push(node.getLeftChild());
      stack.push(node.getRightChild());
    }
  }
}
