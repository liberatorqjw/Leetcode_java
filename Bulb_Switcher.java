package Leetecode;

/**
 * Created by qinjiawei on 16-10-31.
 */

/**
 * 那么最后我们发现五次遍历后，只有1号和4号锁是亮的，而且很巧的是它们都是平方数，
 * 是巧合吗，还是其中有什么玄机。我们仔细想想，对于第n个灯泡，只有当次数是n的因子的之后，
 * 才能改变灯泡的状态，即n能被当前次数整除，比如当n为36时，
 * 它的因数有(1,36), (2,18), (3,12), (4,9), (6,6), 可以看到前四个括号里成对出现的因数各不相同，
 * 括号中前面的数改变了灯泡状态，后面的数又变回去了，等于锁的状态没有发生变化，只有最后那个(6,6)，
 * 在次数6的时候改变了一次状态，没有对应其它的状态能将其变回去了，所以锁就一直是打开状态的。
 * 所以所有平方数都有这么一个相等的因数对，即所有平方数的灯泡都将会是打开的状态
 */
public class Bulb_Switcher {

    /**
     * 找到平方数
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {

        if(n ==1)
            return 1;
        int res = 1;
        while (res * res <= n)
        {
            res++;
        }
        return res ;
    }

    public static void main(String[] args)
    {
        Bulb_Switcher b = new Bulb_Switcher();
        System.out.println(b.bulbSwitch(1));
    }
}
