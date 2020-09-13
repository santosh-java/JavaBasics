package com.cisco.preparation.javabasics.bst;

import java.util.Objects;
import java.util.StringJoiner;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
  private T data;
  private Node<T> leftChild;
  private Node<T> rightChild;

  public Node(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node<T> leftChild) {
    this.leftChild = leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node<T> rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node<?> node = (Node<?>) o;
    return Objects.equals(getData(), node.getData());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getData());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
      .add("data=" + data)
      .toString();
  }

  @Override
  public int compareTo(Node<T> o) {
    return this.getData().compareTo(o.getData());
  }
}
