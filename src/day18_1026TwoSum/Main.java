package day18_1026TwoSum;

import java.util.Scanner;

/**
 * 输入A、B，输出A+B。
 * 输入格式
 *      输入的第一行包括两个整数，由空格分隔，分别表示A、B。
 * 输出格式
 *      输出一行，包括一个整数，表示A+B的值.
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String ab = s.nextLine();
        String[] str = ab.split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        System.out.println(a+b);

    }
}
