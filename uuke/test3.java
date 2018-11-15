package cn.com.srpingboot;

import java.util.Arrays;

public class test3 {

    static int[] cyclic(int[][] ori) {
        int j = ori[0].length;
        int k = ori.length;
        int[] result = new int[j * k];
        int index = 0;
        for (int s = 0; s * 2 < j && s * 2 < k; s++) {
            int width = j - 1 - s;
            int height = k - 1 - s;
            // ->
            for (int a = s; a < width; a++) {
                result[index++] = ori[s][a];
            }
            // |
            for (int a = s; a < height; a++) {
                result[index++] = ori[a][width];
            }
            // <-
            for (int a = width; a > s; a--) {
                result[index++] = ori[height][a];
            }
            // ^|
            for (int a = height; a > s; a--) {
                result[index++] = ori[a][s];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] a = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(cyclic(a)));
    }
}
