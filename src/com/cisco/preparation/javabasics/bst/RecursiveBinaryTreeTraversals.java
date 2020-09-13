package com.cisco.preparation.javabasics.bst;


import com.sun.istack.internal.NotNull;

public class RecursiveBinaryTreeTraversals {

  public void preOrderTraversal(Node<Character> root, @NotNull StringBuilder result) {
    if (root == null) return;
    if (result == null) throw new IllegalArgumentException("Result cannot be null");
    result.append(root.getData());
    preOrderTraversal(root.getLeftChild(), result);
    preOrderTraversal(root.getRightChild(), result);
  }

  public void inOrderTraversal(Node<Character> root, @NotNull StringBuilder result) {
    if (root == null) return;
    if (result == null) throw new IllegalArgumentException("Result cannot be null");
    inOrderTraversal(root.getLeftChild(), result);
    result.append(root.getData());
    inOrderTraversal(root.getRightChild(), result);
  }

  public void postOrderTraversal(Node<Character> root, @NotNull StringBuilder result) {
    if (root == null) return;
    if (result == null) throw new IllegalArgumentException("Result cannot be null");
    postOrderTraversal(root.getLeftChild(), result);
    postOrderTraversal(root.getRightChild(), result);
    result.append(root.getData());
  }

//
//
//  public <T extends Comparable<T>> Node<T> insertRecursive(Node<T> root, T value) {
//    if (value == null) return root;
//    Node<T> newNode = new Node<>(value);
//    if (root == null) return newNode;
//    Node<T> tempRoot = root;
//    boolean insertComplete = false;
//    do {
//      if (tempRoot.compareTo(newNode) > 0) {
//        if (tempRoot.getLeftChild() != null) {
//          tempRoot = tempRoot.getLeftChild();
//        } else {
//          tempRoot.setLeftChild(newNode);
//          insertComplete = true;
//        }
//      } else {
//        if (tempRoot.getRightChild() != null) {
//          tempRoot = tempRoot.getRightChild();
//        } else {
//          tempRoot.setRightChild(newNode);
//          insertComplete = true;
//        }
//      }
//    } while (!insertComplete);
//
//    return root;
//  }
}
