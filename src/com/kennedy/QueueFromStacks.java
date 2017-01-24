package com.kennedy;

import java.util.Stack;

/**
 * Created by adixith on 12/24/16.
 */
public class QueueFromStacks<E> {
    Stack<E> stack1 = new Stack<>();
    Stack<E> stack2 = new Stack<>();

    public void enqueue(E e) {
        stack1.push(e);
    }

    public E dequeue() {
        if(!stack2.isEmpty())
            return stack2.pop();
        while(stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
