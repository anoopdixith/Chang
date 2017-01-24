package com.kennedy;

/**
 * Created by adixith on 12/15/16.
 */
public class TestLinkedListUtility {
    public static void main(String args[]) {
        LinkedListUtility.LLNode node0 = new LinkedListUtility().new LLNode("0");
        LinkedListUtility.LLNode node1 = new LinkedListUtility().new LLNode("1");
        LinkedListUtility.LLNode node2 = new LinkedListUtility().new LLNode("2");
        LinkedListUtility.LLNode node3 = new LinkedListUtility().new LLNode("3");
        LinkedListUtility.LLNode node4 = new LinkedListUtility().new LLNode("4");
        LinkedListUtility.LLNode node5 = new LinkedListUtility().new LLNode("5");
        LinkedListUtility.LLNode node6 = new LinkedListUtility().new LLNode("6");
        LinkedListUtility.LLNode node7 = new LinkedListUtility().new LLNode("7");
        LinkedListUtility.LLNode node8 = new LinkedListUtility().new LLNode("8");
        LinkedListUtility.LLNode node9 = new LinkedListUtility().new LLNode("9");
        LinkedListUtility.LLNode node10 = new LinkedListUtility().new LLNode("10");
        LinkedListUtility.LLNode node11 = new LinkedListUtility().new LLNode("11");
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;



        LinkedListUtility llu = new LinkedListUtility(node0);

        llu.print();
        llu.reverseListSubset(1,3);
        //llu.reverseRecursive();
        //llu.reverseLLIterative();
        System.out.println();
        llu.print();

    }
}
