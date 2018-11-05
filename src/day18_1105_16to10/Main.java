package day18_1105_16to10;

import java.util.Scanner;

/**
 * 问题描述
 * 　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
 * 　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 * 样例输入
 * FFFF
 * 样例输出
 * 65535
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String hex = s.nextLine();
        if(hex.length() > 8){
            return;
        }
//        String b = Integer.toBinaryString(Integer.valueOf(String.valueOf(s), 16));
        //注意，当16进制数输入8位的时候，integer类型的大小时不能对其进行转换的
        // 所以要用 Long 型来进行转换
        // 典型的数据类型选择问题
        String b = Long.toBinaryString(Long.valueOf(String.valueOf(hex), 16));
        long sum = 0;
        long x = 1;
        for(int i = b.length() - 1 ; i >= 0 ; i--){
            sum += Integer.parseInt(String.valueOf(b.charAt(i))) * x;
            x = x * 2;
        }
        System.out.println(sum);
        // java 自带转型方法,将 16 进制 转换为 10 进制
        System.out.println(Long.parseLong(hex,16));

    }
}
