package com.kumanoit.utils.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {

  T value;
  TreeNode<T> leftChild;
  TreeNode<T> rightChild;

  public TreeNode(T value) {
    this.value = value;
    this.leftChild = null;
    this.rightChild = null;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public TreeNode<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(TreeNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  public TreeNode<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(TreeNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  public void printPreOrder() {
    System.out.print(this.getValue() + "\t");
    if (this.leftChild != null) {
      this.leftChild.printPreOrder();
    }
    if (this.rightChild != null) {
      this.rightChild.printPreOrder();
    }
  }
  
  public void printInOrder() {
    if (this.leftChild != null) {
      this.leftChild.printInOrder();
    }
    System.out.print(this.getValue() + "\t");
    if (this.rightChild != null) {
      this.rightChild.printInOrder();
    }
  }

  public void printPostOrder() {
    if (this.leftChild != null) {
      this.leftChild.printPostOrder();
    }
    if (this.rightChild != null) {
      this.rightChild.printPostOrder();
    }
    System.out.print(this.getValue() + "\t");
  }

  public void printLevelOrder() {
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    queue.add(this);
    while (!queue.isEmpty()) {
      TreeNode<T> ptr = queue.remove();
      System.out.print(ptr.getValue() + "\t");
      if (ptr.getLeftChild() != null) {
        queue.add(ptr.getLeftChild());
      }
      if (ptr.getRightChild() != null) {
        queue.add(ptr.getRightChild());
      }
    }
    System.out.println();
  }

  public boolean isLeaf() {
	  return (this.getLeftChild() == null && this.getRightChild() == null);
  }

  public void display() {
    System.out.print("PreOrder Traversal\t:\t");
    this.printPreOrder();
    System.out.print("\nInOrder Traversal\t:\t");
    this.printInOrder();
    System.out.print("\nPostOrder Traversal\t:\t");
    this.printPostOrder();
    System.out.print("\nLevelOrder Traversal\t:\t");
    this.printLevelOrder();
  }
}
