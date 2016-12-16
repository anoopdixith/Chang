package com.kennedy;

/**
 * Created by adixith on 12/15/16.
 */
public class TestLinkedListUtility {
    public static void main(String args[]) {
        LinkedListUtility.LLNode node1 = new LinkedListUtility().new LLNode("1");
        LinkedListUtility.LLNode node2 = new LinkedListUtility().new LLNode("2");
        LinkedListUtility.LLNode node3 = new LinkedListUtility().new LLNode("3");
        LinkedListUtility.LLNode node4 = new LinkedListUtility().new LLNode("4");
        LinkedListUtility.LLNode node5 = new LinkedListUtility().new LLNode("5");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        LinkedListUtility llu = new LinkedListUtility(node1);

        llu.print();
        llu.reverseRecursive();
        //llu.reverseLLIterative();
        System.out.println();
        llu.print();

    }
}
