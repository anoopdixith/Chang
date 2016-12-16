package com.kennedy;

/**
 * Created by adixith on 12/12/16.
 */
public class LinkedListUtility {
    public class LLNode<T> {
        T data;
        LLNode next;
        LLNode previous;

        public LLNode() {
            this(null);
        }
        public LLNode(T t) {
            this(t, null);
        }
        public LLNode(T t, LLNode next) {
            this(t, next, null);
        }

        public LLNode(T t, LLNode next, LLNode previous) {
            this.data = t;
            this.next = next;
            this.previous = previous;
        }
    }

    LLNode head;

    public LinkedListUtility() {
        this.head = null;
    }

    public LinkedListUtility(LLNode node) {
        this.head = node;
    }

    public void print() {
        if(head == null) {
            return;
        }
        LLNode temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            if(temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
    }

    public LLNode reverseLLIterative() {
        if(head == null || head.next == null) {
            return head;
        }
        LLNode prev = head;
        LLNode now = head.next;
        prev.next = null;
        while(now != null) {
            LLNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }
        head = prev;
        return head;
    }


    public void reverseRecursive() {
        head = reverseRecursive(head);
    }

    public LLNode reverseRecursive(LLNode node) {
        if(node == null || node.next == null)
            return node;
        LLNode secondElement = node.next;
        node.next = null;
        LLNode reversed = reverseRecursive(secondElement);
        secondElement.next = node;
        return reversed;
    }

}
