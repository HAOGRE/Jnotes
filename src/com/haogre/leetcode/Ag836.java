package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/rectangle-overlap/
 * @Author : haogre@gmail.com
 * @Date : 2020/5/15 15:42
 * @Version : V1.0
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 **/
public class Ag836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

//        rec1 = [0,0,2,2], rec2 = [1,1,3,3]


//        y1        y2
//
//
//        x1        x2
        // 其中一个坐标落在另外一个坐标围成的图形内


//        x1' < x1 or x2 < x2'
//        y1' < y1 or y2 < y2'

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];


        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    /**
     * 方法二：检查区域 这个要记住
     * 思路
     *
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 xx 轴平行的边（水平边）投影到 xx 轴上时会有交集，与 yy 轴平行的边（竖直边）投影到 yy 轴上时也会有交集。因此，我们可以将问题看作一维线段是否有交集的问题。
     *
     * 算法
     *
     * 矩形 rec1 和 rec2 的水平边投影到 xx 轴上的线段分别为 (rec1[0], rec1[2]) 和 (rec2[0], rec2[2])。根据数学知识我们可以知道，当 min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]) 时，这两条线段有交集。对于矩形 rec1 和 rec2 的竖直边投影到 yy 轴上的线段，同理可以得到，当 min(rec1[3], rec2[3]) > max(rec1[1], rec2[1]) 时，这两条线段有交集。
     *
     *
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

}
