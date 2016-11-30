package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-11-25.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int index =0;
        int[] ret = new int[numCourses];
        if(prerequisites == null || prerequisites.length<1)
            return ret;

        List<Set> posts = new ArrayList<>();
        for (int i =0; i< numCourses; i++)
        {
            posts.add(new HashSet<Integer>());
        }

        for(int i =0; i< prerequisites.length;i++)
        {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] preNums = new int[numCourses];
        for (int i =0; i< numCourses; i++)
        {
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]++;

        }

        for (int i =0; i< numCourses; i++)
        {
            int j =0;
            for (; j< numCourses; j++) {
                if (preNums[j] == 0)
                    break;
            }
            if(j == numCourses)
                break;
            ret[index++] = j;

            Set set = posts.get(j);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]--;

        }
        //只有全满足了才输出
        if(index ==numCourses)
            return ret;
        else
            return new int[0];


    }
}
