package com.kennedy;

/**
 * Created by adixith on 11/2/16.
 */
public class LinkedListNode {
    int data;
    LinkedListNode next;
    public LinkedListNode() {
        this(Integer.MIN_VALUE, null);
    }
    public LinkedListNode(int value) {
        this(value, null);
    }
    public LinkedListNode(int value, LinkedListNode next) {
        this.data = value;
        this.next = next;
    }
}
