package com.kennedy;

/**
 * Created by adixith on 11/2/16.
 */
public class LL<T> {
    private LinkedListNode head;
    private int count;
    public LL() {
        head = new LinkedListNode();
        head.next = null;
        count = 0;
    }

    public void addNode(LinkedListNode newNode) {
        if(count ==0) {
            head = newNode;
            count++;
            return;
        }
        LinkedListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        count++;
    }

    public void printLL() {
        if(count==0) return;
        LinkedListNode temp = head;
        while(temp != null) {
            System.out.print("\t " + temp.data);
            temp = temp.next;
        }
    }


    public static void main(String args[]) {
        LL linkedList = new LL();
        linkedList.addNode(new LinkedListNode(3));
        linkedList.addNode(new LinkedListNode(5));
        linkedList.addNode(new LinkedListNode(1));
        linkedList.addNode(new LinkedListNode(7));
        linkedList.addNode(new LinkedListNode(2));
        linkedList.printLL();
    }
}
