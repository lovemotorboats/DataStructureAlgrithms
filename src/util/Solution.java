package util;

import java.util.Scanner;

public class Solution {
    public static int[][] getAveragePoints(int value){
        //根据m获取平分圆的坐标数组
        //m表示圆平分成几份，圆的半径为R=300,画布宽度980，高度800
        //若以画布左上角为坐标原点，那么圆心坐标为（490， 400）,
        final int RADIUS = 300;
        int[][] points = new int[value][2];  //points[i][0]为横坐标，points[i][1]为纵坐标
        for (int i = 0; i < value; i++){
            points[i][0] = 490 + (int)Math.round(RADIUS * Math.cos(i * 2 * Math.PI / value));
            points[i][1] = 400 - (int)Math.round(RADIUS * Math.sin(i * 2 * Math.PI / value));
        }
        return points;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value;
        for (int i = 0; i < 5; i++){
            value = input.nextInt();
            int[][] result = getAveragePoints(value);
            for (int j = 0; j < value; j++){
                System.out.println("点" + (j + 1) + "坐标为:(" + result[j][0] + "," + result[j][1] + ")");
            }
        }
    }
}

