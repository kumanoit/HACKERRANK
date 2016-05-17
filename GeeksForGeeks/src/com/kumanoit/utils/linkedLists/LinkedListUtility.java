package com.kumanoit.utils.linkedLists;

public class LinkedListUtility {

  /**
   * reverses a linked list
   * @param start
   * @return reversed linked list
   */
  public static <T> LinkedListNode<T> reverseLinkedList(LinkedListNode<T> start) {
    if (start == null || start.getNext() == null) {
      return start;
    }
    LinkedListNode<T> tmp = reverseLinkedList(start.getNext());
    start.getNext().setNext(start);
    start.setNext(null);
    return tmp;
  }

  /**
   * creates a linked list from a given array
   * @param arr
   * @return
   */
  public static <T> LinkedListNode<T> createLinkedList(T[] arr) {
    if (arr.length == 0) {
      throw new NullPointerException("Array size is zero.");
    }
    LinkedListNode<T> start = new LinkedListNode<T>(arr[0]);
    LinkedListNode<T> tmp = start;
    for(int index = 1; index < arr.length; index++) {
      LinkedListNode<T> newNode = new LinkedListNode<T>(arr[index]);
      tmp.setNext(newNode);
      tmp = newNode;
    }
    return start;
  }

}
