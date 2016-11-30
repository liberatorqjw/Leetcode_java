package Leetecode;

/**
 * Created by qinjiawei on 16-5-13.
 */
public class RectangleArea {

    /*
    矩形面积求和 减去重复的面积
    重复的面积就是右上角 左下角
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int allarea = (C-A) * (D-B) + (G-E) * (H-F);

        int la = Math.max(A, E);
        int lb = Math.max(B, F);

        int ra = Math.min(C, G);
        int rb = Math.min(D, H);

        if (la >=ra || lb >= rb)
            return allarea;
        return allarea - (ra - la ) * (rb - lb);
    }
}
