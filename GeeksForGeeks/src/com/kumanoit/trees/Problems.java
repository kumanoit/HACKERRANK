package com.kumanoit.trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kumanoit.utils.trees.TreeNode;

public class Problems {

  public static <T> int getTreeSize(TreeNode<T> root) {
    if (root == null) {
    	return 0;
    }
    return 	1
    		+	getTreeSize(root.getLeftChild())
    		+	getTreeSize(root.getRightChild());
  }

  public static <T> boolean areIdentical(TreeNode<T> root1, TreeNode<T> root2) {
	  if (root1 == null && root2 == null) {
		  return true;
	  }
	  if (root1 == null || root2 == null) {
		  return false;
	  }
	  if (!root1.getValue().equals(root2.getValue())) {
		  return false;
	  }
	  return areIdentical(root1.getLeftChild(), root2.getLeftChild()) &&
			 areIdentical(root1.getRightChild(), root2.getRightChild());
  }

  public static <T> int getTreeDepth(TreeNode<T> root) {
	  if (root == null) {
		  return 0;
	  }
	  int leftHeight = getTreeDepth(root.getLeftChild());
	  int rightHeight = getTreeDepth(root.getRightChild());
	  return 1 + (Math.max(leftHeight, rightHeight));
  }

  public static <T> TreeNode<T> convertToMirrorTree(TreeNode<T> root) {
	  if (root == null) {
		  return null;
	  }
	  TreeNode<T> temp = convertToMirrorTree(root.getLeftChild());
	  root.setLeftChild(convertToMirrorTree(root.getRightChild()));
	  root.setRightChild(temp);
	  return root;
  }

  public static <T> TreeNode<T> deleteTree(TreeNode<T> root) {
	  if (root == null) {
		  return null;
	  }
	  deleteTree(root.getLeftChild());
	  deleteTree(root.getRightChild());
	  root = null;
	  return root;
  }

  public static <T> void printAllRootToLeafPath(TreeNode<T> root, List<T> outputList) {
	if (root.isLeaf()) {
		outputList.forEach(item -> System.out.print(item +","));
		System.out.println(root.getValue());
		return;
	}
	outputList.add(root.getValue());
	printAllRootToLeafPath(root.getLeftChild(), outputList);
	printAllRootToLeafPath(root.getRightChild(), outputList);
	outputList.remove(root.getValue());
  }

  public static <T> TreeNode<T> getLowestCommonAncestor(TreeNode<T> root, T n1, T n2) {
	if (root == null) {
		return null;
	}
	TreeNode<T> left = getLowestCommonAncestor(root.getLeftChild(), n1, n2);
	TreeNode<T> right = getLowestCommonAncestor(root.getRightChild(), n1, n2);
	if (root.getValue().equals(n1) || root.getValue().equals(n2) || (left != null && right != null)) {
		return root;
	}
	return left != null ? left : right;
  }

  public static <T> void printAncestor(TreeNode<T> root, T value, List<T> ancestorList) {
	  if (root == null) {
		  return;
	  }
	  if (value.equals(root.getValue())) {
		  if(ancestorList.isEmpty()) {
			  System.out.println("This is root.");
		  } else {
			  ancestorList.forEach(item -> System.out.print(item + ","));
			  System.out.println();
		  }
//		  System.exit(1);
		  return;
	  }
	  ancestorList.add(root.getValue());
	  printAncestor(root.getLeftChild(), value, ancestorList);
	  printAncestor(root.getRightChild(), value, ancestorList);
	  ancestorList.remove(root.getValue());
  }

  public static <T> int getLevelOfNode(TreeNode<T> root, T value, int level) {
	  if (root == null) {
		  return -1;
	  }
	  if (root.getValue().equals(value)) {
		  return level;
	  }
	  int left = getLevelOfNode(root.getLeftChild(), value, level + 1);
	  if (left != -1) {
		  return left;
	  }
	  int right = getLevelOfNode(root.getRightChild(), value, level + 1);
	  return right != -1 ? right : -1;
  }

  public static <T> void printNodesAtDistanceK(TreeNode<T> root, int k) {
	  if (root == null) {
		  return;
	  }
	  if (k == 1) {
		  System.out.print(root.getValue() + "\t");
		  return;
	  }
	  printNodesAtDistanceK(root.getLeftChild(), k - 1);
	  printNodesAtDistanceK(root.getRightChild(), k - 1);
  }

  public static <T> boolean areFoldable(TreeNode<T> root) {
	  if (root == null) {
		  return true;
	  }
	  return areFoldable(root.getLeftChild(), root.getRightChild());
  }

  private static <T> boolean areFoldable(TreeNode<T> root1, TreeNode<T> root2) {
	  if (root1 == null && root2 == null) {
		  return true;
	  }
	  if (root1 == null || root2 == null) {
		  return false;
	  }
	  return areFoldable(root1.getLeftChild(), root2.getRightChild()) &&
		  areFoldable(root1.getRightChild(), root2.getLeftChild());
  }

  public static <T> int getTreeWidth(TreeNode<T> root) {
	  Map<Integer, Integer> nodeCountMap = new HashMap<Integer, Integer>();
	  getTreeWidth(root, nodeCountMap, 0);
	  int maxWidth = 0;
	  for (Map.Entry<Integer, Integer> entry : nodeCountMap.entrySet()) {
		  maxWidth = Math.max(maxWidth, entry.getValue());
	  }
	  return maxWidth;
  }

  private static <T> void getTreeWidth(TreeNode<T> root, Map<Integer,
		  Integer> nodeCountMap, int level) {
	  if (root == null) {
		  return;
	  }
	  if (nodeCountMap.keySet().contains(level)) {
		  nodeCountMap.put(level, nodeCountMap.get(level) + 1);
	  } else {
		  nodeCountMap.put(level, 1);
	  }
	  getTreeWidth(root.getLeftChild(), nodeCountMap, level + 1);
	  getTreeWidth(root.getRightChild(), nodeCountMap, level + 1);
  }

  public static <T> void doubleTree(TreeNode<T> root) {
	  if (root == null) {
		  return;
	  }
	  doubleTree(root.getLeftChild());
	  doubleTree(root.getRightChild());
	  TreeNode<T> temp = new TreeNode<T>(root.getValue());
	  temp.setLeftChild(root.getLeftChild());
	  root.setLeftChild(temp);
  }

  public static <T> TreeNode<T> constructTreePreOrderInOrder(T[] pre, T[] in) {
	  return constructTreePreOrderInOrder(pre, in, 0, 0, in.length);
  }
  private static <T> TreeNode<T> constructTreePreOrderInOrder(T[] pre, T[] in,
		  int preIndex, int inIndex, int size) {
	  if (size == 0) {
		  return null;
	  }
	  int i = inIndex;
	  while(pre[preIndex] != in[i]) {
		  i++;
	  }
	  TreeNode<T> root = new TreeNode<T>(pre[preIndex]);
	  root.setLeftChild(constructTreePreOrderInOrder(pre, in,
			  preIndex + 1, inIndex, i));
	  root.setRightChild(constructTreePreOrderInOrder(pre, in,
			  preIndex + i + 1, inIndex + i + 1, size - i - 1));
	  return root;
  }
}
