package com.kumanoit.main;

import java.util.ArrayList;

import com.kumanoit.trees.Problems;
import com.kumanoit.utils.trees.TreeNode;
import com.kumanoit.utils.trees.TreeUtility;

public class MyClass {

//  private static Integer[] intArray1 = {33,67,2,5,8,24,64,23,2, 2, 3,477,29,54,70,98,106};
  private static Integer[] intArray1 = {1,2,3,4,5,6,7};
  private static Integer[] intArray2 = {33,67,5,2,8,24,64,23,77,29,54,70,98,106};
  private static String[] stringArray = {"Amit", "Kumar", "Software", "Engineer", "Level2"};

  private static TreeNode<Integer> intRoot1;
  private static TreeNode<Integer> intRoot2;
  private static TreeNode<String> stringRoot;

  static {
    intRoot1 = TreeUtility.createBinaryTree(intArray1);
    intRoot2 = TreeUtility.createBinaryTree(intArray2);
    stringRoot = TreeUtility.createBinaryTree(stringArray);
  }

  private static void convertMirrorTreeDemo(TreeNode<Integer> root) {
	  System.out.println("\n\nAfter mirroring");
	  TreeNode<Integer> mirrorTreeRoot = Problems.convertToMirrorTree(root);
	  mirrorTreeRoot.display();
	  root.display();
  }

  private static void deleteTreeDemo(TreeNode<Integer> root) {
	  System.out.println("After deletion");
	  System.out.println(Problems.deleteTree(root));
	  System.out.println("Root value after deletion.");
	  root.display();
  }

  private static <T> void printAllRootToLeafPathDemp(TreeNode<T> root) {
	  Problems.printAllRootToLeafPath(root, new ArrayList<T>());
  }

  private static <T> void getLowestCommonAncestorDemo(TreeNode<T> root, T n1, T n2) {
	  TreeNode<T> lca = Problems.getLowestCommonAncestor(root, n1, n2);
	  if (lca != null) {
		  System.out.println(lca.getValue());
	  } else {
		  System.out.println("Not found : ");
	  }
  }

  private static <T> void printAncestorDemo(TreeNode<T> root, T value) {
//	  printAncestorDemo(intRoot2, 70);
//	  printAncestorDemo(intRoot2, -1);
//	  printAncestorDemo(intRoot2, 33);
//	  printAncestorDemo(intRoot2, 106);
 	  Problems.printAncestor(root, value, new ArrayList<T>());
  }

  private static <T> void getLevelOfNodeDemo(TreeNode<T> root, T value) {
//	  getLevelOfNodeDemo(intRoot2, 23);
//	  getLevelOfNodeDemo(intRoot2, 54);
//	  getLevelOfNodeDemo(intRoot2, 24);
//	  getLevelOfNodeDemo(intRoot2, 106);
//	  getLevelOfNodeDemo(intRoot2, 33);
	  System.out.println(Problems.getLevelOfNode(root, value, 1));
  }

  private static <T> void printNodesAtDistanceKDemo(TreeNode<T> root, int k) {
//	  printNodesAtDistanceKDemo(intRoot2, 1);
//	  printNodesAtDistanceKDemo(intRoot2, 2);
//	  printNodesAtDistanceKDemo(intRoot2, 3);
//	  printNodesAtDistanceKDemo(intRoot2, 4);
//	  printNodesAtDistanceKDemo(intRoot2, 5);
	  System.out.println("Distance = " + k);
	  Problems.printNodesAtDistanceK(root, k);
	  System.out.println();
  }

  private static void areFoldableDemo() {
	TreeNode<Integer> root = new TreeNode<Integer>(13);
	root.setLeftChild(new TreeNode<Integer>(12));
	root.setRightChild(new TreeNode<Integer>(10));
	root.getLeftChild().setLeftChild(new TreeNode<Integer>(1));
	root.getRightChild().setRightChild(new TreeNode<Integer>(2));
	root.display();
	System.out.println(Problems.areFoldable(root)); // true
	
  }

  private static <T> void getTreeWidthDemo(TreeNode<T> root) {
	  System.out.println(Problems.getTreeWidth(root));
  }

  private static void doubleTreeDemo() {
	  TreeNode<Integer> root = new TreeNode<Integer>(1);
	  root.setLeftChild(new TreeNode<Integer>(2));
	  root.setRightChild(new TreeNode<Integer>(3));
	  root.getLeftChild().setLeftChild(new TreeNode<Integer>(4));
	  root.getLeftChild().setRightChild(new TreeNode<Integer>(5));
	  root.display();
	  Problems.doubleTree(root);
	  root.display();
  }

  private static void constructTreePreOrderInOrder() {
	  System.out.println("Constructing tree from inorder and preorder traversal.");
	  Integer[] pre = {1, 2, 4, 5, 3, 6, 7};
	  Integer[]  in = {4, 2, 5, 1, 6, 3, 7};
	  try {
		  Problems.constructTreePreOrderInOrder(pre, in).display();
	  } catch (NullPointerException e) {
		  System.out.println("There are no nodes in trees.");
	  }
  }

  public static void main(String[] args) {
//	  intRoot1.display();
//	  constructTreePreOrderInOrder();
	  char[] m = new char[30];
	  System.out.println(m.length);
//	  StringBuilder string = new StringBuilder();
//	  for (int beg = 0, end = string.length(); beg < end; beg++, end--) {
//		  char ch = string.charAt(beg);
//		  string.setCharAt(beg, string.charAt(end));
//		  string.setCharAt(end, ch);
		  
//	  }
	  }

}
