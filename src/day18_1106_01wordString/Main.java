package day18_1106_01wordString;

/**
 * 问题描述
 * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 * 请按从小到大的顺序输出这32种01串。
 *
 * 输入格式
 * 本试题没有输入。
 * 输出格式
 * 输出32行，按从小到大的顺序每行一个长度为5的01串。
 * 样例输出
 * 00000
 * 00001
 * 00010
 * 00011
 * <以下部分省略>
 */
public class Main {


    public static void main(String[] args) {
        // 题目要求： 在 A~Z 中，能够从 A 往左或右顺序读
        int n = 32;
        StringBuilder binary;
        for(int i = 0; i < 32 ; i++){
            binary = new StringBuilder(Integer.toBinaryString(i));
            for(int j = binary.length(); j < 5; j++){
                binary.insert(0,0);
            }
            System.out.println(binary);
        }


    }

}
