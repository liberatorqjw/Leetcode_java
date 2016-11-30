package Leetecode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * Created by qinjiawei on 16-4-18.
 */
public class ImplementQueueusingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);

    }

    // Removes the element from in front of queue.
    public void pop() {
        //first time
        if(!stack2.isEmpty())
            stack2.pop();
        else {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        //first time
        if(!stack2.isEmpty())
            return  stack2.peek();
        else {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
             return  stack2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
