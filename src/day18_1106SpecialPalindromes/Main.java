package day18_1106SpecialPalindromes;

import java.util.Scanner;

/**
 * 问题描述
 * 　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
 * 　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
 * 输入格式
 * 　　输入一行，包含一个正整数n。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
 * 样例输入
 * 52
 * 样例输出
 * 899998
 * 989989
 * 998899
 * 数据规模和约定
 * 　　1<=n<=54。
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n < 1 || n > 54){
            return;
        }
        StringBuilder flag = new StringBuilder();
        int sum ;
        // 求五位
        for(int i = 100 ; i <= 999; i++){
            // 判断 组成回文数后各个位之和是否等于n
            flag.append(i);
            sum = Integer.parseInt(String.valueOf(flag.charAt(0)))
                    + Integer.parseInt(String.valueOf(flag.charAt(1)))
                    + Integer.parseInt(String.valueOf(flag.charAt(2)))
                    + Integer.parseInt(String.valueOf(flag.charAt(1)))
                    + Integer.parseInt(String.valueOf(flag.charAt(0))) ;
            if(sum == n){
                flag.append(flag.charAt(1));
                flag.append(flag.charAt(0));
                System.out.println(flag);
            }
            flag.delete(0,flag.length());
        }
        // 求六位
        for(int i = 100 ; i <= 999; i++){
            // 判断 组成回文数后各个位之和是否等于n
            flag.append(i);
            sum = Integer.parseInt(String.valueOf(flag.charAt(0)))
                    + Integer.parseInt(String.valueOf(flag.charAt(1)))
                    + Integer.parseInt(String.valueOf(flag.charAt(2)))
                    + Integer.parseInt(String.valueOf(flag.charAt(2)))
                    + Integer.parseInt(String.valueOf(flag.charAt(1)))
                    + Integer.parseInt(String.valueOf(flag.charAt(0))) ;
            if(sum == n){
                flag.append(flag.charAt(2));
                flag.append(flag.charAt(1));
                flag.append(flag.charAt(0));
                System.out.println(flag);
            }
            flag.delete(0,flag.length());
        }
    }
}
