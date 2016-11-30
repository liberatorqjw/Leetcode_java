package Leetecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by qinjiawei on 16-5-13.
 */
public class ImplementStackusingQueues {

    /*
    两个队列模拟一个堆栈  时刻保持一个是空的
     */
    Queue<Integer> queueA = new LinkedList<Integer>();
    Queue<Integer> queueB  = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        if (queueA.isEmpty())
        {
            queueA.offer(x);
            while (!queueB.isEmpty())
            {
                queueA.offer(queueB.poll());
            }
        }
        else if (queueB.isEmpty())
        {
            queueB.offer(x);
            while (!queueA.isEmpty())
            {
                queueB.offer(queueA.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queueA.isEmpty())
            queueA.poll();
        else
            queueB.poll();

    }

    // Get the top element.
    public int top() {
        if(!queueA.isEmpty())
            return  queueA.peek();
        else
            return  queueB.peek();

    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queueB.isEmpty() && queueA.isEmpty())
            return true;
        else
            return false;
    }
}
