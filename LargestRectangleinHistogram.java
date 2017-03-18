package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qinjiawei on 16-12-29.
 */
public class LargestRectangleinHistogram {

    /**
     * 84
     * 下面介绍新的解法的步骤：

     (1) 在height尾部添加一个0，也就是一个高度为0的立柱。作用是在最后也能凑成上面提的那种“波峰图”。

     (2) 定义了一个stack，然后遍历时如果height[i] 大于stack.top()，进栈。反之，出栈直到栈顶元素小于height[i]。

     由于出栈的这些元素高度都是递增的，我们可以求出这些立柱中所围成的最大矩形。更妙的是，由于这些被弹出的立柱处于“波峰”之上(比如弹出i 到 i+k，那么所有这些立柱的高度都高于 i-1和 i+k+1的高度)，因此，如果我们使用之前所提的“左右延伸找立柱”的思路解，以这些立柱的高度作为整个矩形的高度时，左右延伸出的矩形所包含的立柱不会超出这段“波峰”，因为波峰外的立柱高度都比他们低。“波峰图”其实就是求解最大矩形的“孤岛”，它不会干扰到外部。

     (3) 由于比height[i]大的元素都出完了，height[i]又比栈顶元素大了，因此再次进栈。如此往复，直到遍历到最后那个高度为0的柱，触发最后的弹出以及最后一次面积的计算，此后stack为空。

     (4) 返回面积最大值。

     栈中存的不是高度，而是height的索引，这样做的好处是不会影响宽度的计算，索引值相减 = 宽度。

     例题：
     height的内容是 [5,6,7,8,3]，特点是除了最后一个，前面全部保持递增，且最后一个立柱的高度小于前面所有立柱高度。

     对于这种特点的柱状图，如果使用上面所说的“挨个使用每一个柱状图的高度作为矩形的高度，求面积”的方法，还需要用嵌套循环吗？

     我们知道除了最后一个，从第一个到倒数第二个立柱的高度都在升高，那么如果挨个使用每一个柱的高度作为矩形的高度，那么依次能得到的矩形的宽度就可以直接算出来：使用5作为高度可以使用前四个立柱组成 4*5的矩形，高度6可以组成3*6的矩形... 因此只需要遍历一次，选出最大面积即可。

     对于这种类型的柱状图，最大矩形面积的时间复杂度是O(n)。
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length <0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int[] h = new int[heights.length +1];
        //多在末尾存一个0高度的峰, 那么处理起来
        h = Arrays.copyOf(heights, heights.length +1);
        int max =0;
        //遍历所有的高度
        for (int i =0; i<h.length; i++)
        {
            //栈顶元素大于 当前高度，就要出栈计算
            while (!stack.isEmpty() && h[stack.peek()] > h[i])
            {
                //出栈的元素索引
                int curindex = stack.pop();

                int leftarea = (stack.isEmpty()?curindex+1:curindex-stack.peek()) * h[curindex];
                 // 向右边延伸的大小，但是右边要多减少一个宽度（因为当前i的这个位置它延伸不到，由于比栈顶矮）
                int rightarea = (i-curindex-1) * h[curindex];
                if (leftarea + rightarea > max)
                    max = leftarea + rightarea;

            }
            stack.push(i);
        }

        return max;
    }
}
