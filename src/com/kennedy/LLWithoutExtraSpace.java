package com.kennedy;

/**
 * Created by adixith on 1/9/17.
 */
public class LLWithoutExtraSpace {
    public static class LLnode {
        int data;
        LLnode next;
        public LLnode() {
            this(0, null);
        }
        public LLnode(int data, LLWithoutExtraSpace.LLnode node) {
            this.data = data;
            this.next = node;
        }
        public LLnode(LLWithoutExtraSpace.LLnode node) {
            this(0, node);
        }
        public LLnode(int data) {
            this(data, null);
        }
    }

    LLnode head;
    int count;

    public LLWithoutExtraSpace() {
        this(new LLnode());
    }

    public LLWithoutExtraSpace(LLnode head) {
        this.head = head;
        count++;
    }

    public LLnode append(LLnode newNode) {
        LLnode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        return head;
    }

    public void printLL() {
        printLL(getSize());
    }

    public void printLL(int upTo) {
        LLnode temp = head;
        int counter = 0;
        if(temp == null || upTo < 1)
            return;
        if(temp.next == null || upTo < 2) {
            System.out.println(temp.data);
            return;
        }
        while(temp.next != null && counter < upTo) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            counter++;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public LLnode reverseWithoutExtraSpace() {
        LLnode current = head;
        LLnode previous = null;
        LLnode next = null;
        if(head == null || head.next == null)
            return head;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public int getSize() {
        return count;
    }

    public static void main(String a[]) {
        LLnode headNode = new LLnode(3);
        LLWithoutExtraSpace ll = new LLWithoutExtraSpace(headNode);
        ll.append(new LLnode(5));
        ll.append(new LLnode(2));
        ll.append(new LLnode(4));
        ll.append(new LLnode(9));
        ll.printLL();
        ll.reverseWithoutExtraSpace();
        ll.printLL();
    }
}
