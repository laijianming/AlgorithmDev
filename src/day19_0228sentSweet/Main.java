package day19_0228sentSweet;

import java.util.Scanner;

/**
 * 有 n 个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果， 然后进行下面的游戏：
 * 每个小朋友都把自己的糖果分一半给左手边的孩子。
 * 一轮分糖后，拥有奇数颗糖的孩子由老师补给 1 个糖果，从而变成偶数。
 * 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
 * 你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
 * 【格式要求】
 * 程序首先读入一个整数 N(2<N<100) ，表示小朋友的人数。
 * 接着是一行用空格分开的 N 个偶数（每个偶数不大于 1000 ，不小于 2）
 * 要求程序输出一个整数，表示老师需要补发的糖果数。
 */
public class Main {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String inputSweets = s.nextLine();
//        System.out.println(N);
//        System.out.println(initSweets);
        String[] initSweets = inputSweets.split(" ");
        int[] sweets = new int[N];
        int[] temp = new int[N]; // 分给左边小朋友糖果的数量
        // 初始化初始糖果数量
        for(int i = 0; i < N; i ++){
            sweets[i] = Integer.parseInt(initSweets[i]);
        }
        int count = 0; // 老师需要补发的糖果数
        boolean flag = false;
        // 分糖果
        while (!flag){
            int t = sweets[0];
            int flags = 0;
            for(int i = 0; i < N; i ++){
                if(t == sweets[i]){
                    flags++;
                }
                sweets[i] /= 2;
                temp[i] = sweets[i];
            }
            if(flags == N){
                flag = true;
                break;
            }
            // 收到糖果后的糖果数量
            for(int i = 0; i < N; i ++){
                if(i == 0){
                    sweets[i] += temp[N - 1];
                }else{
                    sweets[i] += temp[i - 1];
                }
            }
            // 给单数的小朋友分一个糖果 也需要判断是否相等
            t = sweets[0];
            flags = 0;
            for(int i = 0; i < N; i ++){
                if(t == sweets[i]){
                    flags++;
                }

                if(sweets[i] % 2 != 0){
                    sweets[i]++;
                    count++;
                }
            }
            if(flags == N){
                flag = true;
                break;
            }
        }
        System.out.println(count);

    }


}
