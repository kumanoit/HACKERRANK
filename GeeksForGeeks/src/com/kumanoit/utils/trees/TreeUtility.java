package com.kumanoit.utils.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility {

  /**
   * Creates a binary tree from given array.
   * Elements are inserted in level order traversal way.
   * @param array
   * @return binary tree's root
   */
  public static <T> TreeNode<T> createBinaryTree(T[] array) {
    if (array.length == 0) {
      throw new NullPointerException("Array length is zero.");
    }
    TreeNode<T> root = new TreeNode<T>(array[0]);
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    queue.add(root);
    int i = 1;
    while (i < array.length && !queue.isEmpty()) {
      TreeNode<T> temp = queue.remove();
      temp.setLeftChild(new TreeNode<T>(array[i++]));
      queue.add(temp.getLeftChild());

      if (i < array.length) {
        temp.setRightChild(new TreeNode<T>(array[i++]));
        queue.add(temp.getRightChild());
      }
    }
    return root;
  }
}
