package com.kumanoit.utils.linkedLists;

  public class LinkedListNode<T> {

  private T value;
  private LinkedListNode<T> next;

  public LinkedListNode(T value, LinkedListNode<T> next) {
    this.value = value;
    this.next = next;
  }

  public LinkedListNode(T value) {
    this(value, null);
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public LinkedListNode<T> getNext() {
    return next;
  }

  public void setNext(LinkedListNode<T> next) {
    this.next = next;
  }

  public void print() {
    LinkedListNode<T> temp = this;
    while(temp != null) {
      System.out.print(temp.value + "  ");
      temp = temp.getNext();
    }
    System.out.println();
  }

  public void addNode(T data) {
    LinkedListNode<T> temp = getLastNode();
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    temp.setNext(newNode);
  }

  public LinkedListNode<T> getLastNode() {
    LinkedListNode<T> temp = this;
    while(temp.getNext() != null) {
      temp = temp.getNext();
    }
    return temp;
  }
}
