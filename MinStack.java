package Leetecode;

import java.util.LinkedList;

/**
 * Created by qinjiawei on 16-4-22.
 */
public class MinStack {

    LinkedList<Integer> statc= new LinkedList<>();
    int min = 0x7fffffff;

    public void push(int x) {
        statc.add(x);
        if(x < min)
            min = x;
    }

    public void pop() {
        if(!statc.isEmpty())
        {
            int cur = statc.getLast();
            statc.remove(statc.size()-1);
            if(min == cur)
            {
                min = 0x7fffffff;
                for (int i =0; i< statc.size(); i++)
                    min = statc.get(i) < min ? statc.get(i):min;
            }

        }

    }

    public int top() {

        return statc.getLast();

    }

    public int getMin() {
        return min;
    }
}
