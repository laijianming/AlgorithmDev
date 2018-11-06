package day18_0000AlgorithmTrain.day18_1106ShortestPath;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        if(N < 3 || N > 100){
            return;
        }
        // 输入点的位置 和 乘客初始位置 和 行李乘客的速度
        while (true){
            if(N == 0){
                break;
            }
            int[][] points = new int[N + 2][2];
            int index = 0;
            for(int i = 0; i < N; i++){
                points[i][0] = s.nextInt();
                points[i][1] = s.nextInt();
                index = i;
            }
            // 输入 乘客起始位置 和 乘客与行李的速度
            for(int i = 0; i < 2; i++){
                points[index + 1][0] = s.nextInt();
                points[index + 1][1] = s.nextInt();
            }
        }

        // 开始计算 时间
//        double Sp = Math.sqrt()


    }



}
