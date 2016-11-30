package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-11-24.
 */
public class CourseSchedule {

    /**
     * 207
     * 拓扑排序找到是否存在环，
     * 用到了矩阵的时候用到了hashset, 去掉了重复的点
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites==null|| prerequisites.length <1)
            return true;
        int h = prerequisites.length;
        int w = prerequisites[0].length;

        List<Set> posts = new ArrayList<Set>();
        // 初始化矩阵
        for (int i=0; i< numCourses; i++)
            posts.add(new HashSet<Integer>());
        //填充矩阵
        for (int i =0 ;i<h; i++)
        {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //入度
        int[] preNums = new int[numCourses];
        for (int i =0 ; i< numCourses; i++)
        {
            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]++;
        }

        for (int i=0; i< numCourses; i++)
        {
            int j =0;
            for (; j< numCourses; j++)
            {
                //j的入度为0
                if(preNums[j] ==0)
                    break;
            }
            //没有找到一个入度为0的
            if (j== numCourses)
                return  false;
            preNums[j] = -1;

            //去掉该节点的所有出度
            Set set = posts.get(j);
            Iterator<Integer> it = set.iterator();
            while (it.hasNext())
                preNums[it.next()]--;

        }
        return true;
    }
}
