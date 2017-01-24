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

    public void reverseListSubset(int start, int end) {
        if(head == null || head.next == null)
            return;
        LLNode movingHead = head, preLink = head;
        int i=0;
        for(; i < start && movingHead != null; i++) {
            preLink = movingHead;
            movingHead = movingHead.next;
        }
        LLNode prev = movingHead;
        LLNode postLink = movingHead;
        LLNode now = movingHead.next;

        for(; (i <= end) && postLink != null; i++) {
            postLink = postLink.next;
        }
            prev.next = postLink;

        for(int pointer = start; pointer < end && now!=null; pointer++) {
                LLNode temp = now.next;
                now.next = prev;
                prev = now;
                now = temp;
        }
        //System.out.println("prelink value is " + preLink.data);
        //System.out.println("prev value is " + prev.data);
        if(prev == head && prev.next != null) {
            prev = prev.next;
            preLink.next = prev.next;
        } else {
            preLink.next = prev;
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
