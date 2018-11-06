package day18_1026ArraySort;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
 * 输入格式
 * 　　第一行为一个整数n。
 * 　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
 * 输出格式
 * 　　输出一行，按从小到大的顺序输出排序后的数列。
 * 样例输入
 * 5
 * 8 3 6 4 9
 * 样例输出
 * 3 4 6 8 9
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n < 1 || n > 200){
            return;
        }
        s.nextLine();
        String array = s.nextLine();
        String[] arrays = array.split(" ");
        // 开始排序
        int[] newArrays = new int[n];
        for(int i = 0; i < arrays.length; i++){
            newArrays[i] = Integer.parseInt(arrays[i]);
        }
        int temp = 0;
        for(int j = 0; j < arrays.length; j++){
            for(int k = 0; k < arrays.length - 1; k++){
                if(newArrays[k] > newArrays[k + 1]){
                    temp = newArrays[k];
                    newArrays[k] = newArrays[k + 1];
                    newArrays[k + 1] = temp;
                }
            }
        }
        String str = "";
        for(int i : newArrays){
            str += i + " ";
        }
        System.out.println(str);
    }
}
