package recursionanddynamicplanning.floodfill;
/*
 * @description:洪水填充算法
 * @author:liyang
 * @create:2020-06-23
 */

// 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
// 给你一个坐标 (sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
// 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。
// 将所有有记录的像素点的颜色值改为新的颜色值,最后返回经过上色渲染后的图像。

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        fill(image, sr, sc, originColor, newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int originColor, int newColor) {
        //超出边界，返回
        if (!isInArea(sr, sc, image)) {
            return;
        }

        //颜色不同，返回
        if (image[sr][sc] != originColor) {
            return;
        }

        if (image[sr][sc] == -1) {
            return;
        }

        image[sr][sc] = -1;  //打标记，以免陷入死循环
        fill(image, sr, sc + 1, originColor, newColor);
        fill(image, sr, sc - 1, originColor, newColor);
        fill(image, sr - 1, sc, originColor, newColor);
        fill(image, sr + 1, sc, originColor, newColor);

        image[sr][sc] = newColor;  //替换颜色

    }

    public boolean isInArea(int x, int y, int[][] image) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        new Solution().floodFill(image, 1, 1, 2);
        System.out.println();
    }
}
