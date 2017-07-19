package dynamicProgramming;

import java.io.*;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-20.
 */
public class RGBDynamic {
    public static int[][] cost;
    public static int[] color;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("rgb.txt")));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n + 1][3];
        color = new int[n + 1];
        map = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            String[] costs = br.readLine().split(" ");
            for (int j = 0; j < costs.length; j++) {
                cost[i][j] = Integer.parseInt(costs[j]);
            }
        }
        color[0] = -1;
        System.out.println(rgb(1, n));

    }

    public static int rgb(int s, int e) {
        if (s > e) {
            return 0;
        } else if(map[s][color[s]]!=0){
            return map[s][color[s]];
        }
        else {
            int min = Integer.MAX_VALUE;
            int minColor = -1;
            for (int i = 0; i < 3; i++) {   // i= color
                if (color[s - 1] != i) {
                    color[s] = i;
                    int temp = cost[s][color[s]] + rgb(s + 1, e);
                    if (min > temp) {
                        min = temp;
                        minColor = i;
                    }
                }
            }
            map[s][minColor] = min;
            return min;
        }
    }

}

